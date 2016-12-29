package com.smk.pay.core.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/1 22:43
 */
public class TestJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("111111");
    }
}
