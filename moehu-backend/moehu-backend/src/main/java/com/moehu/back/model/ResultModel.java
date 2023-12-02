package com.moehu.back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "接口公共返回字段")
public class ResultModel<T> {
    @ApiModelProperty(value = "请求成功的状态码：200 成功，404 失败，500：系统错误")
    private int code;

    @ApiModelProperty(value = "操作的描述信息")
    private String message;

    @ApiModelProperty(value = "接口返回的数据")
    private T data;
}
