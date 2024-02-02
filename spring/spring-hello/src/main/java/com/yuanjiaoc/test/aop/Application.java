package com.yuanjiaoc.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        AService aService = (AService) applicationContext.getBean("aService");
        System.out.println("执行成功，获取AService对象为：" + aService);
    }
}
