package com.yuanjiaoc.dependency.lookup;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
public class HierarchicalDependencyLookupDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
    ac.register(Config1.class);
    ac.refresh();
    ConfigurableListableBeanFactory beanFactory = ac.getBeanFactory();
    System.out.println("父容器" + beanFactory.getParentBeanFactory()); // null
    ac.close();
  }
}
