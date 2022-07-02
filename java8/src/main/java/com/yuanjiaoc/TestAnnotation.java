package com.yuanjiaoc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月02日
 */
public class TestAnnotation {

  public static void main(String[] args) {

    // 判断是否被注解修饰
    boolean isAnnotation = Tony.class.isAnnotationPresent(Role.class);
    System.out.println("tony is decorated by RoleAnnotation:" + isAnnotation);

    // 获取类注解属性
    Role roleAnnotation = Tony.class.getAnnotation(Role.class);
    if (roleAnnotation != null) {
      System.out.println("tony role is:" + roleAnnotation.role());
    }

    Class<Tony> tonyClass = Tony.class;
    try {
      Field field = tonyClass.getField("son");
      roleAnnotation = field.getAnnotation(Role.class);
      if (roleAnnotation != null) {
        System.out.println("field role is:" + roleAnnotation.role());
      }
      Method method = tonyClass.getDeclaredMethod("getDaughter");
      roleAnnotation = method.getAnnotation(Role.class);
      if (roleAnnotation != null) {
        System.out.println("method role is:" + roleAnnotation.role());
      }
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}
