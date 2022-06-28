package com.yuanjiaoc.test;

import com.yuanjiaoc.bean.Blue;
import com.yuanjiaoc.bean.Deg;
import com.yuanjiaoc.config.AutowiredConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
public class AutowiredTest {

  @Test
  public void testAutowired01() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AutowiredConfig.class);
    //    PersonService personService = context.getBean(PersonService.class);
    //    System.out.println(personService);
    //    PersonDao personDao = context.getBean(PersonDao.class);
    //    System.out.println(personDao);
    Deg deg = context.getBean(Deg.class);
    System.out.println(deg);
    context.close();
  }

  @Test
  public void testAutowired02() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AutowiredConfig.class);
    Blue blue = context.getBean(Blue.class);
    context.close();
  }
}
