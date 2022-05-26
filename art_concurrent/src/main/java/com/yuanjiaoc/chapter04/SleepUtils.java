package com.yuanjiaoc.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月26日
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

}
