package com.yuanjiaoc.aop.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
@ComponentScan
@EnableScheduling //在spring容器中启用定时任务的执行
public class MainConfig1 {

    @Bean
    public ScheduledExecutorService scheduledExecutorService() {
        return Executors.newScheduledThreadPool(20);
    }
}
