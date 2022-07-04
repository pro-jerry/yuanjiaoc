package com.yuanjiaoc.test;

import com.yuanjiaoc.aop.AopConfig;
import com.yuanjiaoc.aop.MathCalculator;
import com.yuanjiaoc.aop.MathHandler;
import com.yuanjiaoc.aop.MyClass0;
import com.yuanjiaoc.aop.Pen;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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

  @Test
  public void testAop02() {
    ApplicationContext acx =
        new AnnotationConfigApplicationContext(com.yuanjiaoc.aop.AopConfig.class);
    MathCalculator mathCalculator = acx.getBean(MathCalculator.class);
    mathCalculator.div(2, 1);
  }

  @Test
  public void testAop03() {
    ApplicationContext acx = new AnnotationConfigApplicationContext(AopConfig.class);
    MyClass0 myClass = acx.getBean(MyClass0.class);
    Pen pen = acx.getBean(Pen.class);
    myClass.write(pen);
    myClass.div(10, 1);
  }
}
