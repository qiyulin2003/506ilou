package com.moehu.back.model.response.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@ApiModel(value = "管理后台用户信息")
public class UserLoginModel {

    @ApiModelProperty(value = "用户id")
    Integer admin_user_id;

    @ApiModelProperty(value = "管理员类型：1超级管理员 2 普通管理员")
    Integer admin_user_type;

    @ApiModelProperty(value = "管理员登录用户名")
    String admin_user_name;

    @ApiModelProperty(value = "管理员登录密码")
    String admin_user_pwd;

}
