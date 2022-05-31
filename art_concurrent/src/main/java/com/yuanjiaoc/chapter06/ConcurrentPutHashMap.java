package com.yuanjiaoc.chapter06;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月31日
 */
public class ConcurrentPutHashMap {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }
}
