package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "在线用户Model")
public class OnlineModel {
    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "上次登录时间")
    private String lastlogin_time;

    @ApiModelProperty(value = "在线状态")
    private int online_state;
}
