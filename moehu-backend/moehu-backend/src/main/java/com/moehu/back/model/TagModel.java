package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "标签的Model")
public class TagModel {
    @ApiModelProperty(value = "标签id")
    private int tags_id;

    @ApiModelProperty(value = "作品id")
    private int opus_id;

    @ApiModelProperty(value = "标签的内容")
    private String tags_title;

    @ApiModelProperty(value = "该标签是否为推荐标签")
    private int tags_recommend;

    @ApiModelProperty(value = "创建标签的用户id")
    private int user_id;

    @ApiModelProperty(value = "标签的缩略")
    private String opus_suolue;

}
