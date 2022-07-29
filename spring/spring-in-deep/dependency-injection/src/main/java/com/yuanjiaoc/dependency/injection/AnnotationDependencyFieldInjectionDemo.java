package com.yuanjiaoc.dependency.injection;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于 Java 注解的依赖字段注入示例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月29日
 */
public class AnnotationDependencyFieldInjectionDemo {

  // Autowired annotation is not supported on static fields
  // @Autowired 会忽略掉静态字段
  // @Autowired private static UserHolder userHolder;

  @Autowired private UserHolder userHolder;

  @Autowired private UserHolder userHolder2;

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 注册 Configuration Class（配置类） -> Spring Bean
    applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
    String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-field-injection.xml";
    // 加载 XML 资源，解析并且生成 BeanDefinition
    beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
    // 启动 Spring 应用上下文
    applicationContext.refresh();

    // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
    AnnotationDependencyFieldInjectionDemo demo =
        applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);
    // @Autowired 字段关联
    System.out.println(demo.userHolder);
    System.out.println(demo.userHolder2);
    System.out.println(demo.userHolder == demo.userHolder2); // true

    // 显示地关闭 Spring 应用上下文
    applicationContext.close();
  }

  @Bean
  public UserHolder userHolder(User user) {
    return new UserHolder(user);
  }
}
