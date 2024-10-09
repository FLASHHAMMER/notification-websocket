package com.flashhammer.notification.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableScheduling
public class ExecutorConfiguration implements AsyncConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfiguration.class);

    @Value("${async.executor.corePoolSize:8}")
    private int corePoolSize;

    @Value("${async.executor.maxPoolSize:2000}")
    private int maxPoolSize;

    @Value("${async.executor.queueCapacity:5000}")
    private int queueCapacity;

    @Value("${scheduler.cron.checkNotifications.type}")
    private String checkNotificationsType;
    @Override
    public Executor getAsyncExecutor() {
        return taskExecutor();
    }

    @Bean(name = "threadPoolExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix("Async Executor -");
        logger.debug(
                "Properties - corePoolSize: {}, maxPoolSize: {}, poolSize: {}, activeCount: {}",
                taskExecutor.getCorePoolSize(),
                taskExecutor.getMaxPoolSize(),
                taskExecutor.getPoolSize(),
                taskExecutor.getActiveCount()
        );
        return taskExecutor;
    }

    /*
     *  60000 milliseconds  =   1 minute
     *  1000 milliseconds   =   1 second
     *  0/5 * * * * *       =   Every 5 seconds
     *  * * * * * 0-6       =   Every second, Sunday through Saturday
     *
     *  The cron expression is made of five fields. Each field can have the following values.
     *  |       *	    |        *	      |          *	              |    *	       |          *                 |
     *  | minute (0-59) |   hour (0 - 23) |	day of the month (1 - 31) |	month (1 - 12) |    day of the week (0 - 6) |
     *
     *  Here are some examples for you.
     *  |   Cron expression |	Schedule                            |
     *  |   * * * * *       |	Every minute                        |
     *  |   0 * * * *       |	Every hour                          |
     *  |   0 0 * * *       |	Every day at 12:00 AM               |
     *  |   0 0 * * FRI     |	At 12:00 AM, only on Friday         |
     *  |   0 0 1 * *       |	At 12:00 AM, on day 1 of the month  |
     *
     *  More info: https://crontab.cronhub.io/
     */

    // It starts to run after 1 minute the application started and then runs every 5 minute.
    //@Scheduled(initialDelay = 60000, fixedRate = 300000) // It starts to run after 1 minute the application started and then runs every 5 minute.
    public void doDelayedStart() {
        long t = System.currentTimeMillis();
        getNotifications();
        logger.debug("time taken for task: {} ms", (System.currentTimeMillis() - t));
    }

    //@Scheduled(cron = "${scheduler.cron.checkNotifications.cronExpression}") // "0/5 * * * * *" - Runs every 5 seconds.
    public void doNotifications() {
        logger.debug("[doNotifications] - cron type: {}", checkNotificationsType);
        long t = System.currentTimeMillis();
        checkNotifications();
        logger.debug("time taken for task: {} ms", (System.currentTimeMillis() - t));
    }

    public void getNotifications() {
        logger.debug("[getNotifications] - Run");
    }

    public void checkNotifications() {
        logger.debug("[checkNotifications] - Run");
    }
}

