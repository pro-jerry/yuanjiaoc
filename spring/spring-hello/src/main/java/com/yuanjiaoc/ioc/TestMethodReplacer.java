package com.yuanjiaoc.ioc;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
public class TestMethodReplacer implements MethodReplacer {

  @Override
  public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
    System.out.println("替换了原有的方法");
    return null;
  }
}
