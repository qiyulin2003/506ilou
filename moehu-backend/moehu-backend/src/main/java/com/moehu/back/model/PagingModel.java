package com.moehu.back.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

@Getter
@Setter
@ApiModel(value = "分页的请求参数Model")
public class PagingModel {
    @ApiModelProperty(value = "请求第几页")
    @Min(value = 1,message = "必须大于0")
    private Integer page;

    @ApiModelProperty(value = "每页的页数")
    @Range(min = 10, max = 30,message = "一次性获取最大列表数不能超过30")
    private Integer count;


    @ApiModelProperty(value = "用户id")
    private Integer userid;
}
