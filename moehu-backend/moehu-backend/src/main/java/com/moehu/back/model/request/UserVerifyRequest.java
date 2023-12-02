package com.moehu.back.model.request;

import com.moehu.back.model.DynamicModel;
import com.moehu.back.model.PagingModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@ApiModel(value = "用户昵称，头像，签名的Model")
public class UserVerifyRequest extends PagingModel {

    @ApiModelProperty(value = "用户昵称")
    private String user_id;

    @ApiModelProperty(value = "需要请求的数据类型")
    private String type;

    @ApiModelProperty(value = "审核状态： 0等待审核，1 审核通过， -1 审核拒绝")
    private String user_verify_status;
}