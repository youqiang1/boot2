package com.yq.quartz.config;

import com.yq.quartz.task.CronTask;
import com.yq.quartz.task.HelloTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> 配置</p>
 * @author youq  2020/1/21 15:43
 */
@Configuration
public class TaskConfig {

    @Bean
    public JobDetail helloJobDetail() {
        return JobBuilder.newJob(HelloTask.class).withIdentity("helloJob").storeDurably().build();
    }

    @Bean
    public SimpleTrigger simpleTrigger() {
        //simple类型：可设置时间间隔、是否重复、触发频次（misfire机制）等
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        //一个trigger值对应一个Job，schedule调度器调度Trigger执行对应的Job
        return TriggerBuilder.newTrigger()
                .forJob(helloJobDetail())
                .withIdentity("simpleTrigger")
                .withDescription("simple类型的触发器")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail cronJobDetail() {
        return JobBuilder.newJob(CronTask.class).withIdentity("cronJob").storeDurably().build();
    }

    @Bean
    public CronTrigger cronTrigger() {
        // Cron类型：通过cron表达式设置触发规则 一分钟一次（0 */1 * * * ?）
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 */1 * * * ?")
                .withMisfireHandlingInstructionDoNothing();
        return TriggerBuilder.newTrigger()
                .forJob(cronJobDetail())
                .withIdentity("cronTrigger")
                .withDescription("corn类型的触发器")
                .withSchedule(scheduleBuilder)
                .startNow().build();
    }

}
