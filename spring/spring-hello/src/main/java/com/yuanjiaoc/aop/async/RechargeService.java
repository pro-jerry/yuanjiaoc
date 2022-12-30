package com.yuanjiaoc.aop.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
@Component
public class RechargeService {

    //模拟异步充值
    @Async(MainConfig5.RECHARGE_EXECUTORS_BEAN_NAME)
    public void recharge() {
        System.out.println(Thread.currentThread() + "模拟异步充值");
    }
}
