package com.yuanjiaoc.bean.lifecycle;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化生命周期示例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月22日
 */
public class BeanInstantiationLifecycleDemo {

  public static void main(String[] args) {

    //    executeBeanFactory();

    //    executeBeanAware();
    executeApplicationContext();
  }

  private static void executeBeanAware() {

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 方法一：添加 BeanPostProcessor 实现 MyInstantiationAwareBeanPostProcessor
    beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
    String[] locations = {
      "META-INF/postProcessBeforeInstantiation.xml",
      "META-INF/bean-constructor-dependency-injection.xml"
    };
    int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
    System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
    // 通过 Bean Id 和类型进行依赖查找
    User user = beanFactory.getBean("user", User.class);
    System.out.println(user);

    User superUser = beanFactory.getBean("superUser", User.class);
    System.out.println(superUser);

    // 构造器注入按照类型注入，resolveDependency
    UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
    System.out.println(userHolder);
  }

  private static void executeApplicationContext() {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
    String[] locations = {
      "META-INF/postProcessBeforeInstantiation.xml",
      "META-INF/bean-constructor-dependency-injection.xml"
    };
    applicationContext.setConfigLocations(locations);
    // 启动应用上下文
    applicationContext.refresh();

    User user = applicationContext.getBean("user", User.class);
    System.out.println(user);

    User superUser = applicationContext.getBean("superUser", User.class);
    System.out.println(superUser);

    // 构造器注入按照类型注入，resolveDependency
    UserHolder userHolder = applicationContext.getBean("userHolder", UserHolder.class);
    System.out.println(userHolder);

    // 关闭应用上下文
    applicationContext.close();
  }

  private static void executeBeanFactory() {

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 方法一：添加 BeanPostProcessor 实现 MyInstantiationAwareBeanPostProcessor
    beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
    String[] locations = {
      "META-INF/postProcessBeforeInstantiation.xml",
      "META-INF/bean-constructor-dependency-injection.xml"
    };
    int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
    System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
    // 通过 Bean Id 和类型进行依赖查找
    User user = beanFactory.getBean("user", User.class);
    System.out.println(user);

    User superUser = beanFactory.getBean("superUser", User.class);
    System.out.println(superUser);

    // 构造器注入按照类型注入，resolveDependency
    UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
    System.out.println(userHolder);
  }
}
