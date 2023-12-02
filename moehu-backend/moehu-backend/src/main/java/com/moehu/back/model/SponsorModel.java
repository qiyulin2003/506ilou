package com.moehu.back.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SponsorModel {
    private String sponsor_id;//订阅的id
    private String vip_id;//vip的id
    private Integer user_id;//用户id
    private Integer vip_lv;//vip等级
    private String strat_time;//订阅开始时间
    private String end_time;//订阅截止时间
}
