package com.yuanjiaoc.test;

import com.yuanjiaoc.bean.Person;
import com.yuanjiaoc.config.PropertyValueConfig;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 测试bean的生命周期.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月26日
 */
public class PropertyValueTest {
  @Test
  public void testPropertyValue01() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(PropertyValueConfig.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);

    System.out.println("================================");
    Person person = (Person) context.getBean("person");
    System.out.println(person);
  }

  @Test
  public void testPropertyValue03() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(PropertyValueConfig.class);
    Environment environment = context.getEnvironment();
    String nickName = environment.getProperty("person.nickName");
    System.out.println(nickName);
  }
}
