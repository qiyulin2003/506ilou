package com.moehu.back.config;


import cn.hutool.extra.servlet.ServletUtil;
import com.google.gson.Gson;
import com.moehu.back.dao.UserDao_new;
import com.moehu.back.model.GWFileModel;
import com.moehu.back.utils.EncryptionTools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    @Autowired
    UserDao_new userDao;
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /** 以 controller 包下定义的所有请求为切入点 */
    @Pointcut("execution(public * com.moehu.back.controller..*.*(..))")
    public void webLog() {}

    /**
     * 在切点之前织入
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        logger.info("========================================== Start ==========================================");
        logger.info("接口地址：      : {}", request.getRequestURL().toString());
        logger.info("来源 IP：        : {}", request.getRemoteAddr());
        logger.info("请求方法：      : {}", request.getMethod());
        logger.info("请求入参     : {}", new Gson().toJson(joinPoint.getArgs()));
        logger.info("token 头：        : {}", request.getHeader("token"));
        logger.info("控制器：   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));

        if (request.getRequestURL().toString().indexOf("download")>-1){
            response.setCharacterEncoding("UTF-8");
            GWFileModel model = userDao.getGWFileById(Arrays.toString(args).substring(1,Arrays.toString(args).length()-1));

            if (model!=null){
                // 解密 输出 然后加密
                EncryptionTools.encryptionOrDecryption(model.getFileurl(),model.getFilepath(),model.getFilename(),false);
                File file = new File(model.getFileurl());
                ServletUtil.write(response,file);
                System.out.println("加密文件");
                EncryptionTools.encryptionOrDecryption(model.getFileurl(),model.getFilepath(),model.getFilename(),true);

            }
        }
    }

    @Test
    public void tet(JoinPoint joinPoint) {
        // 下面两个数组中，参数值和参数名的个数和位置是一一对应的。

        System.out.println();
    }
    /**
     * 环绕
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        logger.info("响应参数  : {}", new Gson().toJson(result));
        // 执行耗时
        logger.info("请求耗时         : {} ms", System.currentTimeMillis() - startTime);
        logger.info("=========================================== End ===========================================");
        return result;
    }
}
