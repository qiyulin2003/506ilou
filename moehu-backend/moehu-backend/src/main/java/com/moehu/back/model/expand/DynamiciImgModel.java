package com.moehu.back.model.expand;
import com.moehu.back.model.DynamicModel;
import com.moehu.back.model.ImgModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DynamiciImgModel extends DynamicModel {

    @ApiModelProperty(value = "动态的图片数组")
    private List<ImgModel> dynamic_imgs;
}
