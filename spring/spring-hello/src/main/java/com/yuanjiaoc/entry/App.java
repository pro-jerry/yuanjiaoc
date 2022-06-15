package com.yuanjiaoc.entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
public class App {

  public static void main(String[] args) {

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringConfig.class);
    UserService userService = (UserService) applicationContext.getBean("userService");
    userService.registerUser("ddd@mszlu.com", "123456", "ddd");
  }
}
