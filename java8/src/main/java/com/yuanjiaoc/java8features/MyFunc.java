package com.yuanjiaoc.java8features;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月30日
 */
@FunctionalInterface
public interface MyFunc<T> {

  T getValue(T t);
}
