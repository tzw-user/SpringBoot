package com.example.firstappdemo.config;

import com.example.firstappdemo.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 谭志为 on 2018/9/7.
 */
@Configuration
public class QuartzConfiguration {

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail(){

        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }
    //Trigger
    @Bean
    public Trigger weatherDataSyncJobTrigger(){
        //指定隔几秒
        SimpleScheduleBuilder scheduleBuilder=SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1800).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncJobTrigger").withSchedule(scheduleBuilder).build();
    }
}
