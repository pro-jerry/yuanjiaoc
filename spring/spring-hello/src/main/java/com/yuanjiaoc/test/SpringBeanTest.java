package com.yuanjiaoc.test;

import com.yuanjiaoc.bean.Person;
import com.yuanjiaoc.config.PersonConfig;
import com.yuanjiaoc.config.PersonConfig2;
import com.yuanjiaoc.config.PersonConfig3;
import com.yuanjiaoc.config.ThreadScope;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

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

  @Test
  public void testAnnotationConfig2() {

    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
    // 从Spring容器中获取到的对象默认是单实例的
    Object person1 = context.getBean(Person.class);
    Object person2 = context.getBean(Person.class);
    System.out.println(person1 == person2);
  }

  @Test
  public void testAnnotationConfig3() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
    Object person1 = context.getBean("person");
    Object person2 = context.getBean("person");
    System.out.println(person1 == person2);
  }

  @Test
  public void testAnnotationConfig4() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(PersonConfig3.class);
    // 向容器中注册自定义的scope
    context.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, (Scope) new ThreadScope());
    for (int i = 0; i < 2; i++) {
      new Thread(
              () -> {
                System.out.println(Thread.currentThread() + "," + context.getBean("person"));
                System.out.println(Thread.currentThread() + "," + context.getBean("person"));
              })
          .start();
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void testAnnotationConfig5() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
    System.out.println("IOC容器创建完成");
    Person person1 = (Person) context.getBean("person");
    Person person2 = (Person) context.getBean("person");
    System.out.println(person1 == person2);
  }

  @Test
  public void testAnnotationConfig6() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
    Environment environment = context.getEnvironment();
    String osName = environment.getProperty("os.name");
    System.out.println(osName);

    String[] names = context.getBeanNamesForType(Person.class);
    Arrays.stream(names).forEach(System.out::println);

    Map<String, Person> beans = context.getBeansOfType(Person.class);
    System.out.println(beans);
  }

  @Test
  public void testAnnotationConfig7() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }
}
