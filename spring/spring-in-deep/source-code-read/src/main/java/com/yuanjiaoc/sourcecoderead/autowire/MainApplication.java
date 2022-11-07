package com.yuanjiaoc.sourcecoderead.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月02日
 */
public class MainApplication {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService orderService = applicationContext.getBean(OrderService.class);
//        orderService.query();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.yuanjiaoc.sourcecoderead.autowire");
    }
}
