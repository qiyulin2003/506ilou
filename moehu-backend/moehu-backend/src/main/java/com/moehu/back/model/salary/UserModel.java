package com.moehu.back.model.salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "职员实体类")
public class UserModel {

    @ApiModelProperty(value = "员工工号")
    private int user_id;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "部门id")
    private int dept_id;

    @ApiModelProperty(value = "部门名称")
    private String dept_name;

    @ApiModelProperty(value = "登录账号")
    private String login_name;

    @ApiModelProperty(value = "用户姓名")
    private String user_name;

    @ApiModelProperty(value = "用户类型 00用户 01管理员")
    private String user_type;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phonenumber;

    @ApiModelProperty(value = "性别0女 1男")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账号状态0正常 1停用 ")
    private int status;

    @ApiModelProperty(value = "删除标志0存在 1删除 ")
    private int del_flag;

    @ApiModelProperty(value = "登录ip")
    private String login_ip;

    @ApiModelProperty(value = "登录时间")
    private Date login_date;

    @ApiModelProperty(value = "密码最后更新时间")
    private Date pwd_update_date;

    @ApiModelProperty(value = "创建人")
    private String create_by;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty(value = "更新人")
    private String update_by;

    @ApiModelProperty(value = "更新时间")
    private Date update_time;

    @ApiModelProperty(value = "学历")
    private String xl;

    @ApiModelProperty(value = "职位")
    private String work;

    @ApiModelProperty(value = "工龄")
    private float work_age;

    @ApiModelProperty(value = "工资")
    private float gz;
}
