package com.moehu.back.model;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "App升级的model")
public class UpdateModel {

    @ApiModelProperty(value = "升级表id")
    private int update_id;

    @ApiModelProperty(value = "app版本号")
    private String update_version;

    @ApiModelProperty(value = "整数类型app版本号")
    private int update_version_code;

    @ApiModelProperty(value = "app下载地址")
    private String update_down_url;

    @ApiModelProperty(value = "app更新的内容")
    private String update_content;

    @ApiModelProperty(value = "是否需要强制更新 1 需要，0不需要")
    private int update_force;

    @ApiModelProperty(value = "app下载次数统计")
    private int update_down_count;

    @ApiModelProperty(value = "app安装包大小，单位b")
    private int update_size;

    @ApiModelProperty(value = "app发布版本时间")
    private String update_time;
}
