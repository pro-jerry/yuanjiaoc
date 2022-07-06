package com.yuanjiaoc.java8features;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月01日
 */

/**
 * // @Retention(RetentionPolicy.SOURCE) ，注解仅存在于源码中，在class字节码文件中不包含
 * // @Retention(RetentionPolicy.CLASS)， 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
 * // @Retention(RetentionPolicy.RUNTIME)，注解会在class字节码文件中存在，在运行时可以通过反射获取到
 */

// @Target(ElementType.TYPE) 作用接口、类、枚举、注解
// @Target(ElementType.FIELD) 作用属性字段、枚举的常量
// @Target(ElementType.METHOD) 作用方法
// @Target(ElementType.PARAMETER) 作用方法参数
// @Target(ElementType.CONSTRUCTOR) 作用构造函数
// @Target(ElementType.LOCAL_VARIABLE)作用局部变量
// @Target(ElementType.ANNOTATION_TYPE)作用于注解（@Retention注解中就使用该属性）
// @Target(ElementType.PACKAGE) 作用于包
// @Target(ElementType.TYPE_PARAMETER) 作用于类型泛型，即泛型方法、泛型类、泛型接口 （jdk1.8加入）

// 被@Inherited注解了的注解修饰了一个父类，则它的子类也继承了父类的注解（子类可以同时被其他注解修饰）
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {}
