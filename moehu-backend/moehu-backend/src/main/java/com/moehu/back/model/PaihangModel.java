package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@ApiModel(value = "排行榜Model")
public class PaihangModel {
    @ApiModelProperty(value = "作品id")
    private Integer opus_id;
    @ApiModelProperty(value = "排行id")
    private Integer paihang_id;
    @ApiModelProperty(value = "排名")
    private Integer opus_paiming;
    @ApiModelProperty(value = "数量")
    private Integer counts;
    @ApiModelProperty(value = "类型 1 日排行榜 2 周排行榜 3 月排行榜")
    private Integer type;
    @ApiModelProperty(value = "创建时间")
    private String createtime;

}