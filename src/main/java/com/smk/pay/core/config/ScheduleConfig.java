package com.smk.pay.core.config;

import com.smk.pay.core.job.AutowiringSpringBeanJobFactory;
import com.smk.pay.core.job.TestJob;
import com.smk.pay.core.job.TestJob2;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/1 21:03
 */
//@Configuration
//@EnableScheduling
//@ComponentScan(basePackages = {"com.smk.pay.core"})
public class ScheduleConfig {

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory,
                                                     Trigger[] cronJobTrigger) throws IOException {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setOverwriteExistingJobs(true);
        factoryBean.setJobFactory(jobFactory);
        factoryBean.setStartupDelay(5);
        factoryBean.setTriggers(cronJobTrigger);
        return factoryBean;
    }

    @Bean
    public JobDetailFactoryBean sampleJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(TestJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean(name = "cronJobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(@Qualifier("sampleJobDetail") JobDetail
                                                         jobDetail) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
        factoryBean.setCronExpression("0/5 * * * * ? ");//每5秒执行一次
        return factoryBean;
    }

    @Bean(name = "cronJobTrigger2")
    public CronTriggerFactoryBean cronJobTrigger2(@Qualifier("sampleJobDetail2") JobDetail
                                                          jobDetail) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
        factoryBean.setCronExpression("0/2 * * * * ? ");//每5秒执行一次
        return factoryBean;
    }

    @Bean
    public JobDetailFactoryBean sampleJobDetail2() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(TestJob2.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
}
