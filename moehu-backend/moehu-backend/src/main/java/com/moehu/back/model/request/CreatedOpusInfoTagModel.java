package com.moehu.back.model.request;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatedOpusInfoTagModel {

    @ApiModelProperty(value = "标签的标题")
    private String tags_title;

    @ApiModelProperty(value = "作品id")
    private int opus_id;

    @ApiModelProperty(value = "用户id")
    private int user_id;
}
