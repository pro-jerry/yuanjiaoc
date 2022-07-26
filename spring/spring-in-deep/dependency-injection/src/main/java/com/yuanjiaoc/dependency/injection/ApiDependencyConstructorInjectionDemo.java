package com.yuanjiaoc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 API 实现依赖 Constructor 注入示例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月26日
 */
public class ApiDependencyConstructorInjectionDemo {

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();

    // 生成 UserHolder 的 BeanDefinition
    BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
    // 注册 UserHolder 的 BeanDefinition
    applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

    String xmlResourcePath = "classpath:/META-INF/dependency-constructor-injection-api.xml";
    // 加载 XML 资源，解析并且生成 BeanDefinition
    beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

    // 启动 Spring 应用上下文
    applicationContext.refresh();

    // 依赖查找并且创建 Bean
    UserHolder userHolder = applicationContext.getBean(UserHolder.class);
    System.out.println(userHolder);

    // 显示地关闭 Spring 应用上下文
    applicationContext.close();
  }

  /**
   * 为 {@link UserHolder} 生成 {@link BeanDefinition}
   *
   * @return
   */
  private static BeanDefinition createUserHolderBeanDefinition() {
    BeanDefinitionBuilder definitionBuilder =
        BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
    definitionBuilder.addConstructorArgReference("superUser"); // setter方法调用的顺序是不确定的,构造器的调用顺序是确定的
    return definitionBuilder.getBeanDefinition();
  }
}
