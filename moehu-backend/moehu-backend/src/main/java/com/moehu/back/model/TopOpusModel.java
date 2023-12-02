package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "置顶的Model")
public class TopOpusModel {
    @ApiModelProperty(value = "作品id")
    private int opus_id;
    @ApiModelProperty(value = "用户id")
    private int user_id;
}
