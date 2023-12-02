package com.moehu.back.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "作品的Model")
public class OpusModel {
    @ApiModelProperty(value = "作品id")
    private int opus_id;
    @ApiModelProperty(value = "用户id")
    private int user_id;
    @ApiModelProperty(value = "作品名称")
    private String opus_title;
    @ApiModelProperty(value = "作品介绍")
    private String opus_introduce;
    @ApiModelProperty(value = "作品发布时间")
    private String opus_time;
    @ApiModelProperty(value = "作品点赞数")
    private int opus_satisfied;
    @ApiModelProperty(value = "作品浏览量")
    private int opus_see;
    @ApiModelProperty(value = "作品的关注数量")
    private int opus_follow;

    @ApiModelProperty(value = "作品的收藏数量")
    private int opus_collection;
    @ApiModelProperty(value = "作品的图片")
    private String opus_img;
    @ApiModelProperty(value = "作品的审核状态。等待审核0，审核驳回-1，审核通过1")
    private int opus_status;
    @ApiModelProperty(value = "作品的分类，推荐1，排行2，关注3")
    private int opus_type;

    @ApiModelProperty(value = "作品是否原创 ，1原创，0 非原创")
    private int opus_original;

    @ApiModelProperty(value = "作品公开范围，1所有人，2好友，3不公开")
    private int opus_jurisdiction;

    @ApiModelProperty(value = "作品的标签是否可被编辑，1 开启编辑，0 没有开启编辑")
    private int opus_is_edit;


    @ApiModelProperty(value = "用户名称")
    private String user_name;


    @ApiModelProperty(value = "作者的缩略图")
    private String opus_suolue;

    @ApiModelProperty(value = "作品的缩略图")
    private String suolue_url;

    @ApiModelProperty(value = "作品是否允许评论， 0 不允许 1 允许")
    private int opus_isping;

    @ApiModelProperty(value = "作品的角色性别，1 男，0 女 ,2 通用")
    private int opus_sex;


//    @ApiModelProperty(value = "点赞数的偏移量")
//    private float opus_satisfied_offset;
//    @ApiModelProperty(value = "作品浏览量的偏移量")
//    private float opus_see_offset;
//    @ApiModelProperty(value = "作品的关注数量的偏移量")
//    private float opus_follow_offset;
}