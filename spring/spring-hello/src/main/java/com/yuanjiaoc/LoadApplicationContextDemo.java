package com.yuanjiaoc;

import com.yuanjiaoc.entry.MailService;
import com.yuanjiaoc.entry.UserService;
import com.yuanjiaoc.ioc.GetBeanTest;
import com.yuanjiaoc.ioc.TestChangeMethod;
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

    UserService userService = (UserService) applicationContext.getBean("userService");
    userService.registerUser("ddd@mszlu.com", "123456", "ddd");

    MailService mailService0 = (MailService) applicationContext.getBean("mailService");
    MailService mailService1 = (MailService) applicationContext.getBean("mailService");
    MailService mailService2 = (MailService) applicationContext.getBean("mailService2");
    MailService mailService3 = (MailService) applicationContext.getBean("mailService2");
    System.out.println(mailService0 == mailService1);
    System.out.println(mailService1 == mailService2);
    System.out.println(mailService3 == mailService2);
  }
}
