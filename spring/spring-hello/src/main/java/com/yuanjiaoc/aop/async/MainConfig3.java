package com.yuanjiaoc.aop.async;

import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
@EnableAsync
public class MainConfig3 {

    @Bean
    public LogService logService() {
        return new LogService();
    }

    /**
     * 定义一个AsyncConfigurer类型的bean，实现getAsyncExecutor方法，返回自定义的线程池
     *
     * @param executor
     * @return
     */
    @Bean
    public AsyncConfigurer asyncConfigurer(@Qualifier("logExecutors") Executor executor) {
        return new AsyncConfigurer() {
            @Nullable
            @Override
            public Executor getAsyncExecutor() {
                return executor;
            }
        };
    }

    /**
     * 定义一个线程池，用来异步处理日志方法调用
     *
     * @return
     */
    @Bean
    public Executor logExecutors() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        //线程名称前缀
        executor.setThreadNamePrefix("log-thread-"); //@1
        return executor;
    }
}
