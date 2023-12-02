package com.moehu.back.model.response;

import com.moehu.back.model.OpusModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "排行的Model")
public class RankingResponseModel extends OpusModel {
    @ApiModelProperty(value = "用户头像")
    private String user_head_img;

    @ApiModelProperty(value = "用户昵称")
    private String user_nickname;

    @ApiModelProperty(value = "用户签名")
    private String user_autograph;
}
