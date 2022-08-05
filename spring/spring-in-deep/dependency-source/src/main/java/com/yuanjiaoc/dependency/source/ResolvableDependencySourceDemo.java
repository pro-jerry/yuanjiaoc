package com.yuanjiaoc.dependency.source;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ResolvableDependency 作为依赖来源.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月05日
 */
public class ResolvableDependencySourceDemo {

  @Autowired private String value;

  @PostConstruct
  public void init() {
    System.out.println(value);
  }

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();

    // 注册 Configuration Class（配置类） -> Spring Bean
    applicationContext.register(ResolvableDependencySourceDemo.class);

    applicationContext.addBeanFactoryPostProcessor(
        beanFactory -> {
          // 注册 Resolvable Dependency
          beanFactory.registerResolvableDependency(String.class, "Hello,World");
        });

    // 启动 Spring 应用上下文
    applicationContext.refresh();

    // 显示地关闭 Spring 应用上下文
    applicationContext.close();
  }
}
