package com.yuanjiaoc.dependency.lookup;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 依赖延迟查找.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月12日
 */
public class DependencyDelayLookupDemo {

  public static void main(String[] args) {

    // 创建 BeanFactory 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
    applicationContext.register(DependencyDelayLookupDemo.class);
    // 启动应用上下文
    applicationContext.refresh();

    lookupIfAvailable(applicationContext);
    lookupByStreamOps(applicationContext);

    applicationContext.close();
  }

  private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
    objectProvider.stream().forEach(System.out::println);
    // Hello,World
    // Message
  }

  private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
    User user = userObjectProvider.getIfAvailable(User::createUser);
    System.out.println("当前 User 对象：" + user);
    // 当前 User 对象：User(id=100, name=三省, city=null, workCities=null, lifeCities=null,
    // configFileLocation=null, company=null, context=null, contextAsText=null)
  }

  @Bean
  @Primary
  public String helloWorld() {
    return "Hello,World";
  }

  @Bean
  public String message() {
    return "Message";
  }
}
