package com.yuanjiaoc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月02日
 */
// 定义@Role使用@Repeatable 注解 @Role注：@Repeatable 括号中的类 = 容器注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {

  String role() default "";

  int id();
}
