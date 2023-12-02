package com.moehu.back.model.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ApiModel(value = "分页响应的Model")
public class PagingResponseModel<T> {
    @ApiModelProperty(value = "总页数")
    private int total_page;
    @ApiModelProperty(value = "下一页")
    private int next_page;
    @ApiModelProperty(value = "当前页")
    private int current_page;
    @ApiModelProperty(value = "获取的数据")
    private T result;
}
