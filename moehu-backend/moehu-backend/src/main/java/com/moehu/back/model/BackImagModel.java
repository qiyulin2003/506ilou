package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "PC背景图片的Model")
public class BackImagModel {
    @ApiModelProperty(value = "背景id")
    private int back_id;
    @ApiModelProperty(value = "图片地址")
    private String img_url;
    @ApiModelProperty(value = "用户id")
    private int user_id;

}
