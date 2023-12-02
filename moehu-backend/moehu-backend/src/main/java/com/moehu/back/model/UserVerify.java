package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@ApiModel(value = "用户昵称，头像，签名的Model")
public class UserVerify {

    @ApiModelProperty(value = "用户信息核查表的id")
    private int user_verify_id;

    @ApiModelProperty(value = "用户提交修改的时间")
    private String user_verify_time;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "用户头像")
    private String user_head_img;

    @ApiModelProperty(value = "用户昵称")
    private String user_nickname;

    @ApiModelProperty(value = "用户的个性签名")
    private String user_autograph;

    @ApiModelProperty(value = "审核状态： 0等待审核，1 审核通过， -1 审核拒绝")
    private int user_verify_status;
}
