package com.yuanjiaoc.dependency.injection;

import com.yuanjiaoc.common.domain.User;
import java.util.Set;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * {@link ObjectProvider} 实现延迟依赖注入.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月30日
 */
@Configuration
public class LazyAnnotationDependencyInjectionDemo {

  @Autowired
  @Qualifier("user")
  private User user; // 实时注入

  @Autowired private ObjectProvider<User> userObjectProvider; // 延迟注入

  @Autowired private ObjectFactory<Set<User>> usersObjectFactory;

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 注册 Configuration Class（配置类） -> Spring Bean
    applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

    String xmlResourcePath = "classpath:/META-INF/lazy-annotation-dependency-injection.xml";
    // 加载 XML 资源，解析并且生成 BeanDefinition
    beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

    // 启动 Spring 应用上下文
    applicationContext.refresh();

    // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
    LazyAnnotationDependencyInjectionDemo demo =
        applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);

    // 期待输出 superUser Bean
    System.out.println("demo.user = " + demo.user);

    // 期待输出 superUser Bean
    System.out.println(
        "demo.userObjectProvider = " + demo.userObjectProvider.getObject()); // 继承 ObjectFactory

    // 期待输出 superUser user Beans
    System.out.println("demo.usersObjectFactory = " + demo.usersObjectFactory.getObject());

    System.out.println("------------------------------------------");
    demo.userObjectProvider.forEach(System.out::println);

    // 显示地关闭 Spring 应用上下文
    applicationContext.close();
  }
}
