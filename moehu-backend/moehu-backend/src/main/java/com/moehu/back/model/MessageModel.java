package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "通知的Model")
public class MessageModel {
    @ApiModelProperty(value = "通知id")
    private int message_id;

    @ApiModelProperty(value = "通知内容")
    private String message_content;

    @ApiModelProperty(value = "通知类型")
    private Integer message_type;

    @ApiModelProperty(value = "通知时间")
    private Date message_time;

    @ApiModelProperty(value = "通知状态")
    private Integer message_state;

    @ApiModelProperty(value = "被通知用户id")
    private Integer user_id;

    @ApiModelProperty(value = "提交人")
    private Integer submit_user;

    @ApiModelProperty(value = "是否已读")
    private Integer message_isread;
}
