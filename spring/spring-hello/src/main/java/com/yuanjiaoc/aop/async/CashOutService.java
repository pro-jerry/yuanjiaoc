package com.yuanjiaoc.aop.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
@Component
public class CashOutService {

    //模拟异步提现
    @Async(MainConfig5.CASHOUT_EXECUTORS_BEAN_NAME)
    public void cashOut() {
        System.out.println(Thread.currentThread() + "模拟异步提现");
    }
}
