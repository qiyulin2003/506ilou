package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "作品图片的Model")
public class ImgModel {
    @ApiModelProperty(value = "图片id")
    private int img_id;

    @ApiModelProperty(value = "图片地址")
    private String img_url;

    @ApiModelProperty(value = "图片宽度")
    private Integer img_width;

    @ApiModelProperty(value = "图片高度")
    private Integer img_height;

    @ApiModelProperty(value = "作品id")
    private int opus_id;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "动态id")
    private int dynamic_id;
}
