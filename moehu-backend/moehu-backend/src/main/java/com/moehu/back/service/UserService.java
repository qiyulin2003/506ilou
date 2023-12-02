package com.moehu.back.service;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.UserModel;
import com.moehu.back.model.UserVerify;
import com.moehu.back.model.request.UserVerifyRequest;

import java.util.Map;

public interface UserService {
    ResultModel allUser();
    ResultModel UserLogin(UserModel user);
    ResultModel UserRegister(UserModel User);
    ResultModel UserInfo(UserModel User);
    ResultModel EditUserInfo(UserModel User);
    ResultModel UserVerifyList(UserVerifyRequest user);
    ResultModel UserReview(Map<String, Integer> params);
    ResultModel UserItemInfo(UserVerify user);

    UserModel getUserByIphone(String iphone);
    UserModel getUserById(int id);
}
