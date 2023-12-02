package com.moehu.back.model.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "动态列表中的用户信息")
public class UserInfoResponseModel {

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "用户头像")
    private String user_head_img;

    @ApiModelProperty(value = "用户默认昵称")
    private String user_nickname;
}
