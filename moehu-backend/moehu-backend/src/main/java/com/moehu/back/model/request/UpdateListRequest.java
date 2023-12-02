package com.moehu.back.model.request;

import com.moehu.back.model.PagingModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@ApiModel(value = "请求参数Model")
public class UpdateListRequest extends PagingModel {

    @ApiModelProperty(value = "app版本号")
    private String update_version;

    @ApiModelProperty(value = "app版本id")
    private Integer update_id;

    @ApiModelProperty(value = "是否需要强制更新 1 需要，0不需要")
    private String update_force;
}
