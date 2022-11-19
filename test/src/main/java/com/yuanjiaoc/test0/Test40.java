package com.yuanjiaoc.test0;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月02日
 */
public class Test40 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
//            System.out.println(test());
        }

        String str = "http://hmfpay.smart-tv.cn/paygateway/api/pay/qrcode?orderId=4391865";
        String[] strings = str.split("=");
        System.out.println(strings[1]);
    }

    private static int test() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            pool.execute(new MyTask(map));
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);

        return map.get(MyTask.KEY);
    }

}
