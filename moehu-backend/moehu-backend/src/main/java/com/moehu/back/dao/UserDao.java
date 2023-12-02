package com.moehu.back.dao;

import com.moehu.back.model.BackImagModel;
import com.moehu.back.model.UserModel;
import com.moehu.back.model.UserVerify;
import com.moehu.back.model.request.UserVerifyRequest;
import com.moehu.back.model.response.OpusSearchUser;
import com.moehu.back.model.response.admin.UserLoginModel;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Component
public interface UserDao {
    List<UserModel> allUser();
    UserModel getFindById(int id);

    UserModel getFindById1(int id);

    Integer getFansNums(int id);
    Integer getSatisfiedNums(int id);
    Integer getFollowNums(int id);
    Integer UpdateUserInfo(UserModel user);
    Integer UpdateUserTableItem(UserVerify user);

    Integer UpdateVerifyStatus(int user_verify_id, int user_verify_status);
    UserVerify UserItemInfo(UserVerify user);
    UserModel UserVerifyOneInfo(UserVerify user);
    List<OpusSearchUser> FollowUserList(Integer user_id);
    List<OpusSearchUser> FansUserList(Integer user_id);
    List<UserVerify> UserVerifyList(UserVerifyRequest user);
    Integer insertVerify(Integer user_id, String user_head_img, String user_nickname, String user_autograph);

    UserModel login(UserModel userModel);
    int userRegister(UserModel userModel);

    UserLoginModel adminLogin(UserLoginModel user);
    Integer adminReg(UserLoginModel user);

    UserModel getUserByIphone(String iphone);
    UserModel getUserById(int id);

    Integer getUserIdByPhone(String user_phone);


    Integer addBackImage(BackImagModel model);

    List<BackImagModel> getUserBackImgByUserId(Integer user_id);

    Integer delImagByUserId(Integer user_id);

    Integer setTouImage(UserModel model);

    String getTouImage(UserModel model);

    Integer updateUserInfo(UserModel model);

    Integer changepassword(Map map);

    //判断是否是新用户
    Integer isnewuser(Map map);
    List<UserModel> getuserbyusertype(UserModel model);


    Integer updateuserclass(UserModel model);



    List<UserModel> getuserbytype(UserModel model);

    Integer deluserbyid(UserModel model);

    Integer updateuser(UserModel model);



}

