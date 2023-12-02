package com.moehu.back.model.salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "基本补贴实体类")
public class GZModel {

    @ApiModelProperty(value = "迟到罚款")
    private float chidao;

    @ApiModelProperty(value = "早退罚款")
    private float zaotui;

    @ApiModelProperty(value = "满勤")
    private float quanqin;

    @ApiModelProperty(value = "饭补")
    private float fanbu;

    @ApiModelProperty(value = "交通补贴")
    private float jiaobu;

    @ApiModelProperty(value = "出差补贴")
    private float chaibu;

    @ApiModelProperty(value = "人才补贴")
    private float caibu;

    @ApiModelProperty(value = "工龄补贴")
    private float glbu;

    @ApiModelProperty(value = "职位补贴")
    private float jwbu;

    @ApiModelProperty(value = "五险一金")
    private float wx;


    @ApiModelProperty(value = "加班补贴")
    private float jbbu;
}
