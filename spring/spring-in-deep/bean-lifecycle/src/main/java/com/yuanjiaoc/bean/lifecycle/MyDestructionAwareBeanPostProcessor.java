package com.yuanjiaoc.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * 实现 {@DestructionAwareBeanPostProcessor}
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月26日
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

  @Override
  public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
    if (ObjectUtils.nullSafeEquals("userHolder", beanName)
        && UserHolder.class.equals(bean.getClass())) {
      UserHolder userHolder = (UserHolder) bean;
      // afterSingletonsInstantiated() = The user holder V8
      // UserHolder description = "The user holder V8"
      userHolder.setDescription("The user holder V9");
      System.out.println("postProcessBeforeDestruction() : " + userHolder.getDescription());
    }
  }
}
