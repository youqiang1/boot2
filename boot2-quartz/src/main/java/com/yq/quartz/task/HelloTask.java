package com.yq.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <p> demo</p>
 * @author youq  2020/1/21 15:38
 */
@Slf4j
@Component
public class HelloTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("定时调度任务执行逻辑。。" + LocalDateTime.now());
    }

}
