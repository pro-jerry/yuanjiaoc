package com.yuanjiaoc.aop.async;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
@EnableAsync
public class MainConfig4 {

    @Bean
    public LogService logService() {
        return new LogService();
    }

    @Bean
    public AsyncConfigurer asyncConfigurer() {
        return new AsyncConfigurer() {
            @Nullable
            @Override
            public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
                return new AsyncUncaughtExceptionHandler() {
                    @Override
                    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                        String msg = String.format("方法[%s],参数[%s],发送异常了，异常详细信息:", method, Arrays.asList(params));
                        System.out.println(msg);
                        ex.printStackTrace();
                    }
                };
            }
        };
    }

}
