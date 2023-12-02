package com.moehu.back.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.moehu.back.annotation.PassToken;
import com.moehu.back.annotation.UserLoginToken;
import com.moehu.back.dao.UserDao;
import com.moehu.back.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 全局token拦截和校验
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");

        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)object;
        Method method = handlerMethod.getMethod();

        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {

            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            // 需要token认证
            if (userLoginToken.required()) {

                // 如果请求头没有token
                if (token == null) {
                    throw new RuntimeException("缺少token，请登录");
                }

                // 获取 token 中的 user id
                String userId;

                try {
                    // 解密token，取出 用户id去查询数据
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("无效token，请重新登录");
                }

//                UserModel user = userDao.getFindById(Integer.parseInt(userId));
                UserModel user = userDao.getFindById1(Integer.parseInt(userId));
                log.info("user ======= {}", user.getUser_phone());

                if (user == null ) {
                   throw new RuntimeException("用户不存在，请重新登录");
                }

                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(Integer.toString(user.getUser_id()))).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("无效token，请重新登录");
                }
                return true;
            }

        }

        return true;
    }


}
