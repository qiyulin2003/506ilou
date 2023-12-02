package com.moehu.back.model.salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "打卡时间")
public class ClockInModel {
    @ApiModelProperty(value = "打卡id")
    private int id;

    @ApiModelProperty(value = "时间")
    private Date time;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "是否迟到早退")
    private int islate;
}
