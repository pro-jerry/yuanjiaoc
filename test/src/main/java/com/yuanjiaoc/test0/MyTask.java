package com.yuanjiaoc.test0;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月02日
 */
public class MyTask implements Runnable {

    public static final String KEY = "key";

    private final ConcurrentHashMap<String, Integer> map;

    public MyTask(ConcurrentHashMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (map) {
                this.addup();
            }
        }
    }

    private void addup() {
        if (!map.containsKey(KEY)) {
            map.put(KEY, 1);
        } else {
            map.put(KEY, map.get(KEY) + 1);
        }
    }
}
