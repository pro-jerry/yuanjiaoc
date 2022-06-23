package com.yuanjiaoc.config;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
public interface Scope {

  /**
   * 返回当前作用域中name对应的bean对象.
   *
   * @param name 需要检索的bean的名称
   * @param objectFactory 如果name对应的bean在当前作用域中没有找到，那么可以调用这个ObjectFactory来创建这个对象
   * @return
   */
  Object get(String name, ObjectFactory<?> objectFactory);

  /**
   * 将name对应的bean从当前作用域中移除
   *
   * @return
   */
  @NotNull
  Object remove(String name);

  /**
   * 用于注册销毁回调，如果想要销毁相应的对象,则由Spring容器注册相应的销毁回调，而由自定义作用域选择是不是要销毁相应的对象
   *
   * @param name
   * @param callback
   */
  void registerDestructionCallback(String name, Runnable callback);

  /**
   * 用于解析相应的上下文数据，比如request作用域将返回request中的属性。
   *
   * @param key
   * @return
   */
  @NotNull
  Object resolveContextualObject(String key);

  /**
   * 作用域的会话标识，比如session作用域将是sessionId.
   *
   * @return
   */
  @Nullable
  String getConversationId();
}
