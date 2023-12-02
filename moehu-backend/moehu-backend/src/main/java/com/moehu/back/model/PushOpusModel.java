package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "作品的Model")
public class PushOpusModel {

    @ApiModelProperty(value = "作品id")
    private int opus_id;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "作品名称")
    private String opus_title;

    @ApiModelProperty(value = "作品介绍")
    private String opus_introduce;

    @ApiModelProperty(value = "作品的标签数组")
    private String[] opus_tags;

    @ApiModelProperty(value = "作品的图片数组")
    private String[] opus_imgs;

    @ApiModelProperty(value = "作品的主图")
    private String opus_img;

    @ApiModelProperty(value = "作品公开范围，1所有人，2好友，3不公开")
    private int opus_jurisdiction;

    @ApiModelProperty(value = "是否同步动态")
    private Boolean opus_syncDynamic;

    @ApiModelProperty(value = "作品是否原创 ，1原创，0 非原创")
    private int opus_original;

    @ApiModelProperty(value = "作品发布时间")
    private String opus_time;

    @ApiModelProperty(value = "作品缩略图")
    private String[] opus_suolue;

    @ApiModelProperty(value = "作品性别")
    private int opus_sex;

    @ApiModelProperty(value = "作品是否允许评论")
    private int opus_isping;


}