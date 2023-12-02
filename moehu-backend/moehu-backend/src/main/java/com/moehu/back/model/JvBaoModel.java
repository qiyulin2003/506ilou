package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "举报作品")
public class JvBaoModel {
    @ApiModelProperty(value = "举报id")
    private int jvbao_id;
    @ApiModelProperty(value = "举报作品id")
    private int jvbao_opusid;
    @ApiModelProperty(value = "举报用户id")
    private int jvbao_userid;
    @ApiModelProperty(value = "举报内容")
    private String jvbao_content;
    @ApiModelProperty(value = "创建举报时间")
    private Date jvbao_createtime;
}
