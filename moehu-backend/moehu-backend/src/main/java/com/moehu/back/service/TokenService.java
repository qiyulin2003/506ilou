package com.moehu.back.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.moehu.back.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * 使用 uuid 和 id 生成 token
 */
@Slf4j
@Service()
public class TokenService {

    /** token 过期时间: 8760小时 */
    public static final int CALENDARFIELD = Calendar.HOUR;
    public static final int CALENDARINTERVAL = 8760;

    @Autowired
    public HttpServletRequest request;


    public String createdToken(Integer user_id) {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDARFIELD, CALENDARINTERVAL);
        Date expiresDate = nowTime.getTime();

        String token = "";
        token= JWT.create()
                .withAudience(Integer.toString(user_id)) // 将 uuid 保存到 token 里面
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(String.valueOf(user_id)));// 以 id 作为 token 的密钥
        return token;
    }


    // 从token中解析user_id参数
    public Integer uid() {
        System.out.println("token="+request.getHeader("token"));
        String user_id =  JWT.decode(request.getHeader("token")).getAudience().get(0);
        System.out.println("uid="+user_id);
        return Integer.parseInt(user_id);
    }

}