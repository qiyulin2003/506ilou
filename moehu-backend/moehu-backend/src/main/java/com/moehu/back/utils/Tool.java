package com.moehu.back.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.moehu.back.model.CommentModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Slf4j
public class Tool {

    public static String uuid () {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static<T> JSONObject CountPage(Page page, T list, List<String>... keyword) {
        PageInfo info = new PageInfo<>(page.getResult());
        JSONObject arr = new JSONObject();
        arr.put("total_page", info.getPages());
        arr.put("next_page", info.getNextPage());
        arr.put("current_page", info.getPageNum());
        if (keyword.length != 0) {
            arr.put("keywords", keyword[0]);
        }
        arr.put("result", list);
        return arr;
    }

    /**
     * 字段返回空数组
     * @return
     */
    public static List NullArray() {
        return new ArrayList<>();
    }

    /**
     * 解码base64数据
     * @param msg 需要解码的数据
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decodeBase64(String msg) throws UnsupportedEncodingException {
        byte[] asBytes = Base64.getDecoder().decode(msg);
        return new String(asBytes, StandardCharsets.UTF_8);
    }

    /**
     * 格式化时间
     * @param time
     * @return
     * @throws ParseException
     */
    public static String timeFormat(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = (Date) sdf.parse(time);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }


    public static String lastMonthNow(String time){
        LocalDate today = LocalDate.parse(time.substring(0,10));
        //当前月份+（-1）
        today = today.minusMonths(-1);
        return today+time.substring(10,19);
    }

}
