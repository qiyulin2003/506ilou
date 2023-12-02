package com.moehu.back.model.salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "假条实体类")
public class LeaveModel {

    @ApiModelProperty(value = "假条id")
    private int id;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "用户名称")
    private String user_name;
    @ApiModelProperty(value = "假条内容")
    private String content;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "截至时间")
    private String end_time;

    @ApiModelProperty(value = "时长")
    private float time_num;


    @ApiModelProperty(value = "状态")
    private float status;

    @ApiModelProperty(value = "创建时间")
    private Date create_time; 

}
