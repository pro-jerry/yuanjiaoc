package com.yuanjiaoc.test;

import com.yuanjiaoc.bean.BeanFactoryPostProcessorBean.MyBean;
import com.yuanjiaoc.bean.Person;
import com.yuanjiaoc.config.BeanFactoryPostProcessorConfig;
import com.yuanjiaoc.config.ExtConfig;
import com.yuanjiaoc.config.PersonConfig;
import com.yuanjiaoc.config.PersonConfig2;
import com.yuanjiaoc.config.PersonConfig3;
import com.yuanjiaoc.config.ThreadScope;
import com.yuanjiaoc.processor.User;
import com.yuanjiaoc.service.OrderService;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
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

    Object personFactoryBean = context.getBean("personFactoryBean");
    System.out.println("personFactoryBean实例的类型为：" + personFactoryBean.getClass());

    Object personFactoryBean1 = context.getBean("personFactoryBean");
    Object personFactoryBean2 = context.getBean("personFactoryBean");
    System.out.println("personFactoryBean1类型：" + personFactoryBean1.getClass());
    System.out.println("personFactoryBean2类型：" + personFactoryBean2.getClass());
    System.out.println(personFactoryBean1 == personFactoryBean2);

    Object personFactoryBean3 = context.getBean("&personFactoryBean");
    System.out.println("personFactoryBean3类型：" + personFactoryBean3.getClass());
  }

  @Test
  public void testBeanFactoryPostProcessorBean() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
    MyBean bean = context.getBean(MyBean.class);
    bean.doSomething();
  }

  @Test
  public void testBeanDefinitionRegistryPostProcessor() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
    // 能成功从容器中获取orderService,并成功调用orderService.query();方法
    OrderService orderService = (OrderService) context.getBean(OrderService.class);
    orderService.query();
    context.close();
  }

  @Test
  public void testBeanPostProcessor() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(User.class);
    User user = (User) context.getBean("user");
    System.out.println(user.toString());
  }

  @Test
  public void testMyBeanFactoryPostProcessor() {
    AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext();
    acx.register(ExtConfig.class);
    acx.refresh();
    acx.close();
  }

  @Test
  public void testMyApplicationListener() {
    AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext();
    acx.register(ExtConfig.class);
    acx.refresh();
    acx.publishEvent(new ApplicationEvent(new String("wb发布的事件...")) {});
    // 发布一个自定义事件.
    // 容器关闭
    acx.close();
  }
}
