package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "云盘Model")
public class PanModel {
    @ApiModelProperty(value = "云盘id")
    private String moehu_panid;
    @ApiModelProperty(value = "云盘名称")
    private String moehu_panname;
    @ApiModelProperty(value = "用户id")
    private Integer user_id;
    @ApiModelProperty(value = "云盘大小")
    private Integer moehu_pansize;
    @ApiModelProperty(value = "订阅的用户")
    private String moehu_show_user;

}
