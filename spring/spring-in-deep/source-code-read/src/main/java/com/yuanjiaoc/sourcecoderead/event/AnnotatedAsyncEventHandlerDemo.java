package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月20日
 */
@EnableAsync
public class AnnotatedAsyncEventHandlerDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 1. 注册当前类作为 Configuration Class
        context.register(AnnotatedAsyncEventHandlerDemo.class);

        // 2.启动 Spring 应用上下文
        context.refresh(); // 初始化 ApplicationEventMulticaster

        // 3. 发布自定义 Spring 事件
        context.publishEvent(new MySpringEvent("Hello,World"));

        // 4. 关闭 Spring 应用上下文（ContextClosedEvent）
        context.close();
    }


    @Async // 同步 -> 异步
    @EventListener
    public void onEvent(MySpringEvent event) {
        System.out.printf("[线程 ： %s] onEvent方法监听到事件 : %s\n", Thread.currentThread().getName(), event);
    }


}
