package com.yuanjiaoc.bean;

import com.yuanjiaoc.factory.DefaultUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Spring Bean的初始化
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月08日
 */
@Configuration
public class BeanInitializationDemo {

  public static void main(String[] args) {
    // 创建BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 注册 Configuration Class（配置类）
    applicationContext.register(BeanInitializationDemo.class);
    // 启动 Spring 应用上下文
    applicationContext.refresh();
    // 依赖查找 UserFactory
    DefaultUserFactory defaultUserFactory = applicationContext.getBean(DefaultUserFactory.class);
    System.out.println(defaultUserFactory);
    System.out.println("Spring 应用上下文准备关闭..."); // applicationContext.close() 触发bean的销毁操作
    // 关闭 Spring 应用上下文
    applicationContext.close();
  }

  @Bean(initMethod = "initUserFactory")
  @Lazy(value = false)
  public DefaultUserFactory defaultUserFactory() {
    return new DefaultUserFactory();
  }
}
