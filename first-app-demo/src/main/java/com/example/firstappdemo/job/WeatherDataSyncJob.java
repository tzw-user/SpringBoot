package com.example.firstappdemo.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Weather Data Sync Job
 * Created by 谭志为 on 2018/9/7.
 */
public class WeatherDataSyncJob extends QuartzJobBean{
    private final static Logger logger= LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job ");
    }
}
