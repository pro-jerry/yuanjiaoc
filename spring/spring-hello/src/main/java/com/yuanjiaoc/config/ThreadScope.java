package com.yuanjiaoc.config;

import com.sun.istack.internal.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.ObjectFactory;

/**
 * 自定义本地线程级别的bean作用域，不同的线程中对应的bean实例是不同的，同一个线程中同名的bean是同一个实例
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
public class ThreadScope implements Scope {

  public static final String THREAD_SCOPE = "thread";

  private final ThreadLocal<Map<String, Object>> beanMap =
      new ThreadLocal() {
        protected Object initialValue() {
          return new HashMap<>();
        }
      };

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    Object bean = beanMap.get().get(name);
    if (Objects.isNull(bean)) {
      bean = objectFactory.getObject();
      beanMap.get().put(name, bean);
    }
    return bean;
  }

  @NotNull
  @Override
  public Object remove(String name) {
    return this.beanMap.get().remove(name);
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {
    // bean作用域范围结束的时候调用的方法，用于bean清理
    System.out.println(name);
  }

  @Override
  @NotNull
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Override
  @NotNull
  public String getConversationId() {
    return Thread.currentThread().getName();
  }
}
