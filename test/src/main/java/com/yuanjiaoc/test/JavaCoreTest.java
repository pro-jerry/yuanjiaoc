package com.yuanjiaoc.test;

import cn.hutool.core.util.IdUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月10日
 */
public class JavaCoreTest {

    public static final List<Person> persons = new ArrayList<>();

    public void push(String name) {
        Person person = new Person();
        person.setId(IdUtil.randomUUID());
        person.setName(name);
        persons.add(person);
    }

    public String get() {
        return persons.toString();
    }


    public static void main(String[] args) throws InterruptedException {
        JavaCoreTest test = new JavaCoreTest();

        Thread oneThread = new Thread(new Runnable() {
            @Override
            public void run() {
                test.push("oneThread");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread twoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                test.push("twoThread");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        twoThread.start();

        Thread.sleep(20000L);

        twoThread.join();
        oneThread.join();

        persons.forEach(x -> {
            System.out.println(x.getId() + "----" + x.getName());
        });


    }
}
