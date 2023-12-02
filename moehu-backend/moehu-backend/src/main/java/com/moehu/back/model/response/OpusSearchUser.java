package com.moehu.back.model.response;

import com.moehu.back.model.OpusModel;
import com.moehu.back.model.UserModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@ApiModel(value = "搜索用户返回的Model")
public class OpusSearchUser extends UserModel {
    @ApiModelProperty(value = "当前搜索出来的用户是否被关注了，true关注了，false没关注")
    private boolean have_follow;
}
