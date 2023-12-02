package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ApiModel(value = "评论的Model")
public class CommentModel {
    @ApiModelProperty(value = "评论的id")
    private int comment_id;

    @ApiModelProperty(value = "作品表的作品id")
    private int opus_id;

    @ApiModelProperty(value = "动态的id")
    private int dynamic_id;

    @ApiModelProperty(value = "用户表的用户id")
    private int user_id;

    @ApiModelProperty(value = "评论的内容")
    private String comment_content;

    @ApiModelProperty(value = "评论的时间")
    private String comment_time;

    @ApiModelProperty(value = "回复某个人的comment_id")
    private int comment_reply_id;

    @ApiModelProperty(value = "被回复人的用户名")
    private String comment_to_username;

    @ApiModelProperty(value = "用户名")
    private String user_nickname;

    @ApiModelProperty(value = "用户头像")
    private String user_head_img;

    @ApiModelProperty(value = "评论的类型：1 作品，2 动态")
    private int comment_type;

    private List<CommentModel> child;
}
