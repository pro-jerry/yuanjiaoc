package com.yuanjiaoc.test;

import com.yuanjiaoc.config.AnimalConfig;
import com.yuanjiaoc.config.LifeCircleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试bean的生命周期.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
public class BeanLifeCircleTest {

  @Test
  public void testBeanLifeCircle01() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(LifeCircleConfig.class);
    System.out.println("容器创建完成...");
    context.close();
  }

  @Test
  public void testBeanLifeCircle02() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AnimalConfig.class);
    System.out.println("IOC容器创建完成...");
    // 关闭IOC容器
    context.close();
  }

  @Test
  public void testBeanLifeCircle03() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(AnimalConfig.class);
    System.out.println("IOC容器创建完成...");
    System.out.println("-------");
    // 调用时创建对象
    Object bean = ctx.getBean("animal");
    System.out.println("-------");
    // 调用时创建对象
    Object bean1 = ctx.getBean("animal");
    System.out.println("-------");
    // 关闭IOC容器
    ctx.close();
  }

  @Test
  public void testBeanLifeCircle04() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AnimalConfig.class);
    context.close();
  }
}
