package com.yuanjiaoc.bean;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class BeanAliasDemo {

  public static void main(String[] args) {
    // 配置 XML 配置文件
    // 启动 Spring 应用上下文
    BeanFactory beanFactory =
        new ClassPathXmlApplicationContext("classpath:/META-INF/application-alias.xml");
    // 通过别名 xiaomage-user 获取曾用名 user 的 bean
    User user = beanFactory.getBean("user", User.class);
    User xiaomageUser = beanFactory.getBean("yuan-user", User.class);
    System.out.println("yuan-user 是否与 user Bean 相同：" + (user == xiaomageUser));
  }
}
