package com.moehu.back.utils;

import com.moehu.back.model.PaihangModel;
import com.moehu.back.model.PushOpusModel;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaihangQuartz  extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("第二个定时器quartz task "+new Date());
        //两个小时整理下排行榜
        //获取作品浏览量 按年月日获取 获取每天的点赞量
        //每天保存排行榜
        //从moehu_see表获取今日浏览量


    }




}
