package com.yuanjiaoc.dependency.injection;

import com.yuanjiaoc.common.domain.User;
import com.yuanjiaoc.dependency.injection.annotation.InjectedUser;
import com.yuanjiaoc.dependency.injection.annotation.MyAutowired;
import java.util.Map;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 注解驱动的依赖注入处理过程.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月30日
 */
@Configuration
public class AnnotationDependencyInjectionResolutionDemo {

  @Autowired // 依赖查找（处理） + 延迟
  @Lazy
  private User lazyUser;

  // DependencyDescriptor ->
  // 必须（required=true）
  // 实时注入（eager=true)
  // 通过类型（User.class）
  // 字段名称（"user"）
  // 是否首要（primary = true)
  @Autowired // 依赖查找（处理）
  private User user;

  @Autowired // 集合类型依赖注入
  private Map<String, User> users; // user superUser

  @Inject private User injectedUser;

  @MyAutowired private Optional<User> userOptional; // superUser

  @InjectedUser private User myInjectedUser;

  @Bean
  @Order(Ordered.LOWEST_PRECEDENCE - 3)
  @Scope
  public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
    AutowiredAnnotationBeanPostProcessor beanPostProcessor =
        new AutowiredAnnotationBeanPostProcessor();
    beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
    return beanPostProcessor;
  }

  public static void main(String[] args) {

    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 注册 Configuration Class（配置类） -> Spring Bean
    applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

    String xmlResourcePath = "classpath:/META-INF/lazy-annotation-dependency-injection.xml";
    // 加载 XML 资源，解析并且生成 BeanDefinition
    beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

    // 启动 Spring 应用上下文
    applicationContext.refresh();

    // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
    AnnotationDependencyInjectionResolutionDemo demo =
        applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);

    // 期待输出 superUser Bean
    System.out.println("demo.user = " + demo.user);
    System.out.println("demo.injectedUser = " + demo.injectedUser);

    // 期待输出 user superUser
    System.out.println("demo.users = " + demo.users);
    // 期待输出 superUser Bean
    System.out.println("demo.userOptional = " + demo.userOptional);
    // 期待输出 superUser Bean
    System.out.println("demo.myInjectedUser = " + demo.myInjectedUser);

    // 显示地关闭 Spring 应用上下文
    applicationContext.close();
  }
}
