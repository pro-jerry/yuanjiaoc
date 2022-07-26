package com.yuanjiaoc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * "constructor" Autowiring 依赖构造器注入示例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月26日
 */
public class AutoWiringConstructorDependencyConstructorInjectionDemo {

  public static void main(String[] args) {

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

    String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-constructor-injection.xml";
    // 加载 XML 资源，解析并且生成 BeanDefinition
    beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
    // 依赖查找并且创建 Bean
    UserHolder userHolder = beanFactory.getBean(UserHolder.class);
    System.out.println(userHolder);
  }
}
