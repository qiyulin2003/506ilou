package com.moehu.back.service.impl.admin;

import com.alibaba.fastjson.JSONObject;
import com.moehu.back.dao.UserDao;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.response.admin.UserLoginModel;
import com.moehu.back.service.TokenService;
import com.moehu.back.service.admin.AdminUserService;
import com.moehu.back.utils.MD5;
import com.moehu.back.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenService tokenService;

    @Override
    public ResultModel login(UserLoginModel user) {
        System.out.println("============name:"+user.getAdmin_user_name());
        System.out.println("============pwd:"+user.getAdmin_user_pwd());
        String MD5Str=MD5.encode(user.getAdmin_user_pwd());
        user.setAdmin_user_pwd(MD5Str);
        System.out.println("=============md5pwd:"+MD5Str);
        System.out.println("==========user"+user.getAdmin_user_pwd());
        UserLoginModel u = userDao.adminLogin(user);
        if (u == null) {
            return ResultUtils.Error("登录失败，用户不存在");
        } else {
            JSONObject jsonObject = new JSONObject();
            String token = tokenService.createdToken(u.getAdmin_user_id());
            jsonObject.put("user_token", token);
            jsonObject.put("user_info", u);
            return ResultUtils.Success(jsonObject);
        }
    }

    @Override
    public ResultModel reg(UserLoginModel user) {
        user.setAdmin_user_pwd(MD5.encode(user.getAdmin_user_pwd()));
        if ( userDao.adminReg(user) == 0) {
            return ResultUtils.Error("已经注册过啦~");
        }
        return ResultUtils.SuccessStatus("注册成功");
    }
}
