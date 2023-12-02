package com.moehu.back.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 设置请求基地址的前缀
 */
@Component("api.path")
@Getter
@Setter
public class ApiPathProperties {

    @Value("${api.path.app}")
    String appPrefix;

    @Value("${api.path.admin}")
    String adminPrefix;
}