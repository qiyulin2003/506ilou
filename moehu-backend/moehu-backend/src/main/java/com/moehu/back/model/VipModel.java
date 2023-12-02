package com.moehu.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "VipModel")
public class VipModel {
    @ApiModelProperty(value = "VIP id")
    private String vip_id;
    @ApiModelProperty(value = "VIP 名称")
    private String vip_name;
    @ApiModelProperty(value = "VIP 介绍")
    private String vip_introduce;
    @ApiModelProperty(value = "VIP 价格")
    private Integer vip_price;
    @ApiModelProperty(value = "VIP 封面")
    private String vip_fengmian;
    @ApiModelProperty(value = "VIP 等级")
    private Integer vip_lv;
    @ApiModelProperty(value = "用户id")
    private Integer user_id;

}
