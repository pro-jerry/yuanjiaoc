package com.yuanjiaoc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月26日
 */
public class BeanLifeCycle {

  public static void main(String[] args) {
    System.out.println("现在开始初始化容器");

    ApplicationContext factory = new ClassPathXmlApplicationContext("beanlifecycle.xml");
    System.out.println("容器初始化成功 ---18");
    Student student = factory.getBean("student", Student.class);
    System.out.println(student.toString());
  }
}
