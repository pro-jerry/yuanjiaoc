package com.yuanjiaoc.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 加载配置文件
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
public class LoadApplicationContextDemo {

  public static void main(String[] args) {

    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    GetBeanTest getBeanTest = (GetBeanTest) applicationContext.getBean("getBeanTest");
    getBeanTest.showMe();
    TestChangeMethod testChangeMethod =
        (TestChangeMethod) applicationContext.getBean("testChangeMethod");
    testChangeMethod.changeMe();
  }
}
