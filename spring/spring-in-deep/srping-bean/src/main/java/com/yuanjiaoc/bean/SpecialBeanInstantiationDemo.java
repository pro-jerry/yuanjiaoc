package com.yuanjiaoc.bean;

import static java.util.ServiceLoader.load;

import com.yuanjiaoc.factory.DefaultUserFactory;
import com.yuanjiaoc.factory.UserFactory;
import java.util.Iterator;
import java.util.ServiceLoader;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 特殊的bean实例化
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class SpecialBeanInstantiationDemo {

  public static void main(String[] args) {
    // 配置 XML 配置文件
    // 启动 Spring 应用上下文
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext(
            "classpath:/META-INF/application-special-bean-instantiation.xml");
    // 通过 ApplicationContext 获取 AutowireCapableBeanFactory
    AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
    ServiceLoader<UserFactory> serviceLoader =
        beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

    //      demoServiceLoader();
    displayServiceLoader(serviceLoader);

    // 创建 UserFactory 对象，通过 AutowireCapableBeanFactory
    UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
    System.out.println(userFactory.createUser());
  }

  public static void demoServiceLoader() {
    ServiceLoader<UserFactory> serviceLoader =
        load(UserFactory.class, Thread.currentThread().getContextClassLoader());
    displayServiceLoader(serviceLoader);
  }

  private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
    Iterator<UserFactory> iterator = serviceLoader.iterator();
    while (iterator.hasNext()) {
      UserFactory userFactory = iterator.next();
      System.out.println(userFactory.createUser());
    }
  }
}
