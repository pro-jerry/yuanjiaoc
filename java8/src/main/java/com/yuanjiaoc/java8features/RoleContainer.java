package com.yuanjiaoc.java8features;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月02日
 */
// 定义 容器注解 @RoleContainer容器注解本身也是一个注解，用于存放其他注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleContainer {

  Role[] value();
}
