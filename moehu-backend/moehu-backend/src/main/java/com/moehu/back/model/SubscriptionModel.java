package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "SubscriptionModel")
public class SubscriptionModel {
    @ApiModelProperty(value = "订阅 id")
    private String subscription_id;
    @ApiModelProperty(value = "订阅 作品标题")
    private String subscription_title;
    @ApiModelProperty(value = "订阅 作品介绍")
    private String subscription_introduce;
    @ApiModelProperty(value = "订阅 作品内容")
    private String subscription_content;
    @ApiModelProperty(value = "订阅 作品封面")
    private String subscription_fengmian;
    @ApiModelProperty(value = "订阅 会员等级")
    private Integer subscription_vip;
    @ApiModelProperty(value = "订阅 权限")
    private Integer subscription_isread;
    @ApiModelProperty(value = "用户id")
    private Integer user_id;
    @ApiModelProperty(value = "订阅 问题")
    private String subscription_question;
    @ApiModelProperty(value = "订阅 答案")
    private String subscription_answer;
    @ApiModelProperty(value = "创建时间")
    private String createtime;

    @ApiModelProperty(value = "作品描述")
    private String description;


}
