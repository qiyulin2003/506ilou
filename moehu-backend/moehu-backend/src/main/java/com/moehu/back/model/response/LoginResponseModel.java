package com.moehu.back.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "登录注册响应的Model")
public class LoginResponseModel<T> {
    @ApiModelProperty(value = "用户Token")
    private String user_token;
    @ApiModelProperty(value = "用户信息")
    private T user_info;
}
