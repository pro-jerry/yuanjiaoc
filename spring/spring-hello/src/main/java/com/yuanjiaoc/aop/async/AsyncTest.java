package com.yuanjiaoc.aop.async;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class AsyncTest {

    @Test
    public void test1() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        LogService logService = context.getBean(LogService.class);
        System.out.println(Thread.currentThread() + " logService.log start," + System.currentTimeMillis());
        logService.log("异步执行方法!");
        System.out.println(Thread.currentThread() + " logService.log end," + System.currentTimeMillis());

        //休眠一下，防止@Test退出
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig2.class);
        context.refresh();
        GoodsService goodsService = context.getBean(GoodsService.class);

        long starTime = System.currentTimeMillis();
        System.out.println("开始获取商品的各种信息");

        long goodsId = 1L;
        Future<String> goodsInfoFuture = goodsService.getGoodsInfo(goodsId);
        Future<String> goodsDescFuture = goodsService.getGoodsDesc(goodsId);
        Future<List<String>> goodsCommentsFuture = goodsService.getGoodsComments(goodsId);

        System.out.println(goodsInfoFuture.get());
        System.out.println(goodsDescFuture.get());
        System.out.println(goodsCommentsFuture.get());

        System.out.println("商品信息获取完毕,总耗时(ms)：" + (System.currentTimeMillis() - starTime));

        //休眠一下，防止@Test退出
        TimeUnit.SECONDS.sleep(6);
    }

    @Test
    public void test3() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig3.class);
        context.refresh();
        LogService logService = context.getBean(LogService.class);
        System.out.println(Thread.currentThread() + " logService.log start," + System.currentTimeMillis());
        logService.log("异步执行方法!");
        System.out.println(Thread.currentThread() + " logService.log end," + System.currentTimeMillis());

        //休眠一下，防止@Test退出
        TimeUnit.SECONDS.sleep(3);
    }
}
