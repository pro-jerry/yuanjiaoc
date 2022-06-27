package com.yuanjiaoc.test;

import com.yuanjiaoc.config.AutowiredConfig;
import com.yuanjiaoc.service.PersonService;
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
    PersonService personService = context.getBean(PersonService.class);
    System.out.println(personService);
    //    PersonDao personDao = context.getBean(PersonDao.class);
    //    System.out.println(personDao);
    context.close();
  }
}
