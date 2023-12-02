package com.moehu.back.utils;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
    }
    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(86400)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail paihangQuartzDetail(){
        return JobBuilder.newJob(PaihangQuartz.class).withIdentity("paihangQuartz").storeDurably().build();
    }
    @Bean
    public Trigger paihangQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(86400)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(paihangQuartzDetail())
                .withIdentity("paihangQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
