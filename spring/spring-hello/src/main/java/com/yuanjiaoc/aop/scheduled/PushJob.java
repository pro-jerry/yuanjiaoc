package com.yuanjiaoc.aop.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
@Component
public class PushJob {

    //推送方法，每秒执行一次
    @Scheduled(fixedRate = 1000)
    public void push() throws InterruptedException {
        System.out.println("模拟推送消息，" + System.currentTimeMillis());
    }
}
