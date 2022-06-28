package com.yuanjiaoc.test;

import com.yuanjiaoc.aop.MathHandler;
import com.yuanjiaoc.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试切面.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
public class AopTest {

  @Test
  public void testAop01() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AopConfig.class);
    MathHandler mathHandler = context.getBean(MathHandler.class);
    mathHandler.add(1, 2);
    context.close();
  }
}
