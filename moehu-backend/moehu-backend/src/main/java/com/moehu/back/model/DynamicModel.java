package com.moehu.back.model;


import com.moehu.back.model.response.UserInfoResponseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "动态的Model")
public class DynamicModel {

    @ApiModelProperty(value = "动态id")
    private int dynamic_id;

    @ApiModelProperty(value = "作品id")
    private int opus_id;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "动态的内容")
    private String dynamic_introduce;

    @ApiModelProperty(value = "动态是否置顶，1置顶，0不置顶")
    private int dynamic_top;

    @ApiModelProperty(value = "动态的发布时间")
    private String dynamic_time;

    @ApiModelProperty(value = "动态分享的数量")
    private int dynamic_share_count;

    @ApiModelProperty(value = "动态被评论的数量")
    private int dynamic_comment_count;

    @ApiModelProperty(value = "动态点赞的数量")
    private int dynamic_satisfied_count;

    @ApiModelProperty(value = "投稿动态：'投稿了新作'，如果是普通动态为'' ")
    private String dynamic_text;

    @ApiModelProperty(value = "动态的类型：1 投稿动态，2：普通动态")
    private int dynamic_type;

    @ApiModelProperty(value = "动态的封面图")
    private String dynamic_img;

    @ApiModelProperty(value = "用户信息")
    private UserInfoResponseModel user_info;

}
