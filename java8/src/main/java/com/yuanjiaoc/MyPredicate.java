package com.yuanjiaoc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月29日
 */
public interface MyPredicate<T> {

  /**
   * 对传递过来的T类型的数据进行过滤 符合规则返回true，不符合规则返回false
   *
   * @param t
   * @return
   */
  boolean filter(T t);
}
