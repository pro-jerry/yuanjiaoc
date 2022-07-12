package com.yuanjiaoc.dependency.lookup;

import com.yuanjiaoc.bean.Person;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
public class DependencyLookupDemo {

  public static void main(String[] args) {
    BeanFactory beanFactory =
        new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
    //    lookupInRealTime(beanFactory);
    //    lookupInLazy(beanFactory);
    //    lookupByType(beanFactory);
    lookupByCollectionType(beanFactory);
    //    lookupByAnnotationType(beanFactory);
  }

  private static void lookupInRealTime(BeanFactory beanFactory) {
    Person person = (Person) beanFactory.getBean("person");
    System.out.println("实时查找：" + person);
  }

  private static void lookupInLazy(BeanFactory beanFactory) {
    ObjectFactory<Person> objectFactory =
        (ObjectFactory<Person>) beanFactory.getBean("objectFactory");
    Person user = objectFactory.getObject();
    System.out.println("延迟查找：" + user);
  }

  private static void lookupByType(BeanFactory beanFactory) {
    Person user = beanFactory.getBean(Person.class);
    System.out.println("根据Bean类型查找：" + user);
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {

    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, Person> users = listableBeanFactory.getBeansOfType(Person.class);
      System.out.println("查找到所有的User集合对象：" + users);
      String[] beanNames = listableBeanFactory.getBeanNamesForType(Person.class);
      for (String beaName : beanNames) {
        System.out.println(beaName);
      }
    }
  }

  private static void lookupByAnnotationType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, Person> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
      System.out.println("查找标注@Supper 的所有集合对象：" + users);
      Arrays.stream(listableBeanFactory.getBeanNamesForAnnotation(Super.class))
          .forEach(System.out::println);
    }
  }
}
