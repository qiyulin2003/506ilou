package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "收藏列表的Model")
public class CollectionModel {

    @ApiModelProperty(value = "作品的封面图")
    private String opus_img;

    @ApiModelProperty(value = "作品详情的图片数组")
    private String[] opus_imgs;
}
