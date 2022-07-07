package com.yuanjiaoc.bean;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class BeanInstantiationDemo {

  public static void main(String[] args) {
    // 配置 XML 配置文件
    // 启动 Spring 应用上下文
    BeanFactory beanFactory =
        new ClassPathXmlApplicationContext(
            "classpath:/META-INF/application-bean-instantiation.xml");
    User user = beanFactory.getBean("user-by-static-method", User.class);
    User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
    User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
    System.out.println(user);
    System.out.println(userByInstanceMethod);
    System.out.println(userByFactoryBean);

    System.out.println(user == userByInstanceMethod);
    System.out.println(user == userByFactoryBean);
  }
}
