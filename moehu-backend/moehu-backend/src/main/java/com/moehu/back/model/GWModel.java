package com.moehu.back.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GWModel {
    private int id;
    private String gwbz;
    private String gwurl;

    private String re_name;
    private String send_dept;
    private String re_dept;
    private int re_user;
    private int user_id;

    private String file_id;
    private String create_time;
    private int status;
    private int del_flag;

}
