package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "聊天记录的Model")
public class ChatRecordModel {
    @ApiModelProperty(value = "接收人id")
    private int record_id;
    @ApiModelProperty(value = "记录内容")
    private String record_content;
    @ApiModelProperty(value = "聊天室id")
    private int chatroom_id;
    @ApiModelProperty(value = "提交人")
    private int submit_user;
    @ApiModelProperty(value = "提交时间")
    private Date submit_time;

    @ApiModelProperty(value = "消息状态")
    private int record_state;



}
