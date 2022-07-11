package com.yuanjiaoc.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
public class ObjectProviderDemo {

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
    applicationContext.register(ObjectProviderDemo.class);
    // 启动应用上下文
    applicationContext.refresh();
    // 依赖查找集合对象
    lookupByObjectProvider(applicationContext);

    // 关闭应用上下文
    applicationContext.close();
  }

  @Bean
  public String helloWorld() { // 当bean的名称没有定义的时候,方法名就是 Bean 名称 = "helloWorld"
    return "Hello,World";
  }

  private static void lookupByObjectProvider(
      AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
    System.out.println(objectProvider.getObject());
  }
}
