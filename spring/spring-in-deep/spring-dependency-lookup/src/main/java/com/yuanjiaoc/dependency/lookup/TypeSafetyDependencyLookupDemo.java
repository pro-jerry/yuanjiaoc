package com.yuanjiaoc.dependency.lookup;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全 依赖查找示例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月12日
 */
public class TypeSafetyDependencyLookupDemo {

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 将当前类 TypeSafetyDependencyLookupDemo 作为配置类（Configuration Class）
    applicationContext.register(TypeSafetyDependencyLookupDemo.class);
    // 启动应用上下文
    applicationContext.refresh();

    // 演示 BeanFactory#getBean 方法的安全性-不安全
    displayBeanFactoryGetBean(applicationContext);
    // 演示 ObjectFactory#getObject 方法的安全性-不安全
    displayObjectFactoryGetObject(applicationContext);
    // 演示 ObjectProvider#getIfAvaiable 方法的安全性-安全
    displayObjectProviderIfAvailable(applicationContext);

    // 演示 ListableBeanFactory#getBeansOfType 方法的安全性
    displayListableBeanFactoryGetBeansOfType(applicationContext);
    // 演示 ObjectProvider Stream 操作的安全性
    displayObjectProviderStreamOps(applicationContext);

    applicationContext.close();
  }

  public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
    printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
  }

  private static void displayObjectFactoryGetObject(
      AnnotationConfigApplicationContext applicationContext) {
    // ObjectProvider is ObjectFactory
    ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
    printBeansException("displayObjectFactoryGetObject", () -> userObjectFactory.getObject());
  }

  private static void displayObjectProviderIfAvailable(
      AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
    printBeansException(
        "displayObjectProviderIfAvailable", () -> userObjectProvider.getIfAvailable());
  }

  private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
    printBeansException(
        "displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(User.class));
  }

  private static void displayObjectProviderStreamOps(
      AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
    printBeansException(
        "displayObjectProviderStreamOps", () -> userObjectProvider.forEach(System.out::println));
  }

  private static void printBeansException(String source, Runnable runnable) {
    System.err.println("==========================================");
    System.err.println("Source from :" + source);
    try {
      runnable.run();
    } catch (BeansException exception) {
      exception.printStackTrace();
    }
  }
}
