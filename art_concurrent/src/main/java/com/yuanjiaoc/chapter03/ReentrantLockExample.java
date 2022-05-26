package com.yuanjiaoc.chapter03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月22日
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer(){
        lock.lock(); // 获取锁
        try {
            a++;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void reader (){
        lock.lock(); // 获取锁
        try {
            int i = a;
        } finally {
            lock.unlock();// 释放锁
        }
    }
}
