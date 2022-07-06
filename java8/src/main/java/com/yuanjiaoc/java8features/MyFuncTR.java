package com.yuanjiaoc.java8features;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月30日
 */
@FunctionalInterface
public interface MyFuncTR<T, R> {

  R getValue(T t1, T t2);
}
