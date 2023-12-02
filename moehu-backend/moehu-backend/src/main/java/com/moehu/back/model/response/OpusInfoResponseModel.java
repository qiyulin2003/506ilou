package com.moehu.back.model.response;

import com.moehu.back.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "作品详情的Model")
public class OpusInfoResponseModel extends OpusModel {

//    @ApiModelProperty(value = "作品的评论，如果没有显示null")
//    private List<CommentModel> comment;

    @ApiModelProperty(value = "作者的往期最新作品，只返回10条，更多的需要去个人空间查看，如果没有显示null")
    private List<OpusModel> news_opus;

    @ApiModelProperty(value = "发布该作品的用户信息")
    private UserModel user_info;

    @ApiModelProperty(value = "作品的所有图片合集")
    private List<ImgModel> opus_imgs;

    @ApiModelProperty(value = "作品相关的tag标签")
    private List<TagModel> tags;

}
