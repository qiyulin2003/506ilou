package com.moehu.back.model.salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "部门实体类")
public class DeptModel {

    @ApiModelProperty(value = "部门id")
    private int dept_id;

    @ApiModelProperty(value = "部门名称")
    private String dept_name;

    @ApiModelProperty(value = "部门负责人")
    private String leader;

    @ApiModelProperty(value = "部门负责人电话")
    private String phone;

    @ApiModelProperty(value = "部门负责人邮箱")
    private String email;

    @ApiModelProperty(value = "删除标志0存在 1删除 ")
    private int del_flag;

    @ApiModelProperty(value = "创建人")
    private String create_by;

    @ApiModelProperty(value = "创建时间")
    private Date create_time; 

}
