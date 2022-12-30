package com.yuanjiaoc.aop.async;

import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Component
public class LogService {

    @Async
    public void log(String msg) throws InterruptedException {
        System.out.println(Thread.currentThread() + "开始记录日志," + System.currentTimeMillis());
        //模拟耗时2秒
        TimeUnit.SECONDS.sleep(2);
        System.out.println("------------>>:" + msg);
        System.out.println(Thread.currentThread() + "日志记录完毕," + System.currentTimeMillis());
    }
}
