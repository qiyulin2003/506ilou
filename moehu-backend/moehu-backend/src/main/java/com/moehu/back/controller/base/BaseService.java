package com.moehu.back.controller.base;

import com.moehu.back.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    public TokenService tokenService;
}
