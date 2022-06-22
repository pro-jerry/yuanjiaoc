package com.yuanjiaoc.test;

import com.yuanjiaoc.bean.Person;
import com.yuanjiaoc.config.PersonConfig;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
public class SpringBeanTest {

  @Test
  public void testXmlConfig() {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Person person = (Person) context.getBean("person");
    System.out.println(person);
  }

  @Test
  public void testAnnotationConfig() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
    Person person = context.getBean(Person.class);
    System.out.println(person);

    // 按照类型查找对应的bean数组
    String[] names = context.getBeanNamesForType(Person.class);
    Arrays.stream(names).forEach(System.out::println);
  }

  @Test
  public void testComponentScanByXml() {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  @Test
  public void testComponentScanByAnnotation() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }
}
