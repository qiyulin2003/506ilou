package com.moehu.back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "用户信息的公共接口")
public class UserModel {
    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "班级id")
    private int class_id;



    @ApiModelProperty(value = "孩子信息")
    private UserModel child;
    @ApiModelProperty(value = "课程id")
    private int course_id;

    @ApiModelProperty(value = "课程名称")
    private String course_name;
    @ApiModelProperty(value = "孩子手机号")
    private String child_phone;
    @ApiModelProperty(value = "用户的手机号")
    private String user_phone;

    @ApiModelProperty(value = "用户上传id字符串")
    private String user_id_str;

    @ApiModelProperty(value = "用户的密码")
    private String user_pwd;
    @ApiModelProperty(value = "用户真实姓名")
    private String user_real_name;
    @ApiModelProperty(value = "用户身份证")
    private String user_id_card;
    @ApiModelProperty(value = "用户邮箱")
    private String user_email;
    @ApiModelProperty(value = "用户银行卡")
    private String user_bank_card;
    @ApiModelProperty(value = "用户性别")
    private String user_sex;
    @ApiModelProperty(value = "用户的职业")
    private String user_work;
    @ApiModelProperty(value = "用户头像")
    private String user_head_img;
    @ApiModelProperty(value = "用户默认昵称")
    private String user_nickname;
    @ApiModelProperty(value = "用户申请账号的固定ID，不可修改")
    private String user_uid;
    @ApiModelProperty(value = "用户注册的时间")
    private String user_reg_time;
//    @ApiModelProperty(value = "用户最后一次登录ip")
//    private String user_ip;
    @ApiModelProperty(value = "用户出生日期")
    private String user_birthday;
    @ApiModelProperty(value = "用户的星座")
    private String user_constellation;
    @ApiModelProperty(value = "用户签名")
    private String user_autograph;

    @ApiModelProperty(value = "用户输入的验证码")
    private String sms_code;

    @ApiModelProperty(value = "用户类型用户类型（0系统用户 1学生 2 家长 3 教练）")
    private Integer user_type;




}
