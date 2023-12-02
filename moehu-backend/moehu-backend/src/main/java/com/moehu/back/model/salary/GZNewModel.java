package com.moehu.back.model.salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "保存工资实体类改")
public class GZNewModel {
    @ApiModelProperty(value = "工资实体")
    private int id;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "用户名称")
    private String user_name;

    @ApiModelProperty(value = "基本工资")
    private float base_gz;

    @ApiModelProperty(value = "交通补贴")
    private float jt;

    @ApiModelProperty(value = "请假扣除")
    private float qj;


    @ApiModelProperty(value = "迟到")
    private float cd;

    @ApiModelProperty(value = "加班")
    private float jb;

    @ApiModelProperty(value = "出差")
    private float cc;

    @ApiModelProperty(value = "人才")
    private float rc;

    @ApiModelProperty(value = "餐补")
    private float cb;

    @ApiModelProperty(value = "满勤")
    private float mq;


    @ApiModelProperty(value = "五险一金")
    private float wx;

    @ApiModelProperty(value = "工龄")
    private float gl;

    @ApiModelProperty(value = "个税")
    private float gs;

    @ApiModelProperty(value = "总计")
    private float zj;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;
}
