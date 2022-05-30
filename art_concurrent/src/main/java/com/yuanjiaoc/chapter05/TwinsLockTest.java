package com.yuanjiaoc.chapter05;

import com.yuanjiaoc.chapter04.SleepUtils;
import java.util.concurrent.locks.Lock;
import org.junit.jupiter.api.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月30日
 */
public class TwinsLockTest {

    @Test
    public void test(){
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
