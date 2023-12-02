package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "发送短信的Model")
public class SMSModel {
    @ApiModelProperty(value = "短信id")
    private int sms_id;

    @ApiModelProperty(value = "需要发送的手机号")
    private String sms_iphone;

    @ApiModelProperty(value = "短信内容")
    private String sms_content;

    @ApiModelProperty(value = "短信的模板代码")
    private String sms_tempcode;
    @ApiModelProperty(value = "短信的提交日期")
    private String sms_subtime;
}
