package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "云盘记录Model")
public class PanRecordModel {
    @ApiModelProperty(value = "作品集 记录id")
    private String moehu_record_id;
    @ApiModelProperty(value = "作品集 记录名称")
    private String moehu_record_name;
    @ApiModelProperty(value = "作品集封面")
    private String record_fengmian;
    @ApiModelProperty(value = "作品集类型 0 图片 1 文本 2压缩包")
    private Integer record_type;
    @ApiModelProperty(value = "作品集价格")
    private Integer record_price;
    @ApiModelProperty(value = "云盘id")
    private String moehu_pan_id;
    @ApiModelProperty(value = "作品集介绍")
    private String record_introduce;
    @ApiModelProperty(value = "作品集创建时间")
    private String record_createtime;
}
