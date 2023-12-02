package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "聊天室的Model")
public class ChatRoomModel {
    @ApiModelProperty(value = "聊天室id")
    private int chatroom_id;
    @ApiModelProperty(value = "submit_id")
    private int submit_id;
    @ApiModelProperty(value = "聊天室人数")
    private int chatroom_num;

    @ApiModelProperty(value = "用户1")
    private int user_1;
    @ApiModelProperty(value = "用户2")
    private int user_2;
    @ApiModelProperty(value = "用户3")
    private int user_3;
    @ApiModelProperty(value = "用户4")
    private int user_4;
    @ApiModelProperty(value = "用户5")
    private int user_5;

    @ApiModelProperty(value = "未读信息数")
    private int not_read;
}
