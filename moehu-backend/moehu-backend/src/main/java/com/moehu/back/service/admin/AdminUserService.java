package com.moehu.back.service.admin;

import com.moehu.back.model.ResultModel;
import com.moehu.back.model.response.admin.UserLoginModel;

public interface AdminUserService {
    ResultModel login(UserLoginModel user);
    ResultModel reg(UserLoginModel user);
}
