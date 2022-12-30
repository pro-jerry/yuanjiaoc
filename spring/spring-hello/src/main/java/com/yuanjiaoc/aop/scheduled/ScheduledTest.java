package com.yuanjiaoc.aop.scheduled;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月30日
 */
public class ScheduledTest {

    @Test
    public void test1() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        //休眠一段时间，房子junit自动退出
        TimeUnit.SECONDS.sleep(10000);
    }
}
