package com.yuanjiaoc.dependency.injection.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义注解（元标注 @Autowired）.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月30日
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface MyAutowired {

  /**
   * Declares whether the annotated dependency is required.
   *
   * <p>Defaults to {@code true}.
   */
  boolean required() default true;
}
