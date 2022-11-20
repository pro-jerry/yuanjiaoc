package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
@ComponentScan("com.yuanjiaoc.sourcecoderead.event")
public class ListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(ListenerDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        userService.register();
        context.close();
    }
}
