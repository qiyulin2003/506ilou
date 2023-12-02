package com.moehu.back.config;

import com.moehu.back.annotation.AdminRestController;
import com.moehu.back.annotation.AppRestController;
import com.moehu.back.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class ApiPathWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private ApiPathProperties apiPathProperties;

    /**
     * 类上如果有
     *   AppRestController，那么设置前缀 为 /app
     *   AdminRestController，那么设置前缀 为 /admin
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer
                .addPathPrefix(apiPathProperties.getAppPrefix(),c -> c.isAnnotationPresent(AppRestController.class))
                .addPathPrefix(apiPathProperties.getAdminPrefix(),c -> c.isAnnotationPresent(AdminRestController.class));
    }


    /**
     * 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}