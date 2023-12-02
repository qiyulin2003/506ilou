package com.moehu.back.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.moehu.back.dao.UserDao;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.UserModel;
import com.moehu.back.model.UserVerify;
import com.moehu.back.model.request.UserVerifyRequest;
import com.moehu.back.model.response.OpusSearchUser;
import com.moehu.back.service.TokenService;
import com.moehu.back.service.UserService;
import com.moehu.back.utils.ResultUtils;
import com.moehu.back.utils.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserModel userModel;


    @Override
    public ResultModel allUser() {
        return null;
    }

    @Override
    public ResultModel UserRegister(UserModel user) {
        user.setUser_nickname(user.getUser_nickname());
        user.setUser_uid(Tool.uuid());
        if ( userDao.userRegister(user) == 0) {
            return ResultUtils.Error("已经注册过啦");
        }
        return ResultUtils.SuccessStatus("注册成功");
    }

    @Override
    public ResultModel UserLogin(UserModel user) {
        System.out.println("用户输入的密码是"+user.getUser_pwd());
        JSONObject jsonObject = new JSONObject();
        UserModel userModel = userDao.login(user);
        if (userModel == null) {
            return ResultUtils.Error("登录失败，用户不存在");
        } else {
            if (user.getUser_pwd().equals(userModel.getUser_pwd())){
                log.info("userModel.getUser_id() ========== {}", userModel.getUser_id());
                String token = tokenService.createdToken(userModel.getUser_id());
                jsonObject.put("user_token", token);
                jsonObject.put("user_info", userModel);
                return ResultUtils.Success(jsonObject);
            }else {
                ResultModel result=new ResultModel();
                result.setMessage("密码错误");
                result.setCode(500);
                return result;
            }
        }
    }

    @Override
    public ResultModel UserInfo(UserModel User) {
        UserModel user = userDao.getFindById(User.getUser_id());
        // 粉丝数量 也就是 别人关注我的数量
        Integer FansNums = userDao.getFansNums(User.getUser_id());
        // 点赞数量
        Integer SatisfiedNums = userDao.getSatisfiedNums(User.getUser_id());
        if (SatisfiedNums == null) {
            SatisfiedNums = 0;
        }

        // 关注数量 也就是 我关注别人的数量
        Integer FollowNums = userDao.getFollowNums(User.getUser_id());

        JSONObject userJson = new JSONObject();
        userJson.put("user_id", user.getUser_id());
        userJson.put("user_head_img", user.getUser_head_img());
        userJson.put("user_nickname", user.getUser_nickname());
        userJson.put("user_autograph", user.getUser_autograph());
        userJson.put("user_birthday", user.getUser_birthday());
        userJson.put("user_work", user.getUser_work());
        userJson.put("user_sex", user.getUser_sex());
        userJson.put("user_email", user.getUser_email());
        userJson.put("user_constellation", user.getUser_constellation());
        userJson.put("uid",user.getUser_uid());
        userJson.put("fans_nums", FansNums);
        userJson.put("satisfied_nums", SatisfiedNums);
        userJson.put("follow_nums", FollowNums);
        userJson.put("email",user.getUser_email());
        return ResultUtils.Success(userJson);
    }

    @Override
    public ResultModel EditUserInfo(UserModel User) {
        User.setUser_id(tokenService.uid());
        userDao.UpdateUserInfo(User);
        Integer addStatus = userDao.insertVerify(
                User.getUser_id(), User.getUser_head_img(),
                User.getUser_nickname(), User.getUser_autograph()
        );

        if (addStatus == 0) {
            return ResultUtils.SuccessStatus("已经提交过修改，正在审核！");
        } else {
            return ResultUtils.SuccessStatus("修改成功，请等待审核");
        }
    }

    @Override
    public ResultModel UserVerifyList(UserVerifyRequest user) {
        user.setUserid(tokenService.uid());
        Page page = PageHelper.startPage(user.getPage(), user.getCount());
        List<UserVerify> list = userDao.UserVerifyList(user);

        if (list.isEmpty()) {
            List a = new ArrayList();
            return ResultUtils.Success(a);
        } else {
            return ResultUtils.Success(Tool.CountPage(page,list));
        }
    }

    @Override
    public ResultModel UserReview(Map<String, Integer> params) {

        // 通过审核
        if (params.get("user_verify_status").equals(1)) {
            log.info("---------------- 通过审核");

            // 1：修改审核的状态码
            userDao.UpdateVerifyStatus(params.get("user_verify_id"), 1);
            UserVerify u = new UserVerify();
            // 保存审核id
            u.setUser_verify_id(params.get("user_verify_id"));
            // 查询对应的被审核数据
            UserVerify oneUser = userDao.UserItemInfo(u);
            // 更新moehu_user 表中对应的字段
            userDao.UpdateUserTableItem(oneUser);
            return ResultUtils.SuccessStatus("审核通过");

        // 拒绝通过
        } else if (params.get("user_verify_status").equals(-1)) {
            log.info("---------------- 拒绝通过");
            userDao.UpdateVerifyStatus(params.get("user_verify_id"), -1);
            return ResultUtils.SuccessStatus("拒绝通过");
        } else {
            return ResultUtils.SuccessStatus("参数错误");
        }
    }

    @Override
    public ResultModel UserItemInfo(UserVerify user) {
        UserModel list = userDao.UserVerifyOneInfo(user);
        if (list == null) {
            return ResultUtils.Error("没有数据~");
        } else {
            return ResultUtils.Success(list);
        }
    }

    @Override
    public UserModel getUserByIphone(String iphone) {
        UserModel userModel = userDao.getUserByIphone(iphone);
        return userModel;
    }





    @Override
    public UserModel getUserById(int id) {
        return userDao.getUserById(id);
    }
}
