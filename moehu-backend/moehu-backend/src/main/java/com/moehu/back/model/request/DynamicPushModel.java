package com.moehu.back.model.request;

import com.moehu.back.model.DynamicModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamicPushModel extends DynamicModel {

    @ApiModelProperty(value = "动态的图片数组")
    private String[] dynamic_imgs;
}
