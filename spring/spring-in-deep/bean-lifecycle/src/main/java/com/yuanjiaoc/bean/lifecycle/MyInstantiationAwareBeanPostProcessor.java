package com.yuanjiaoc.bean.lifecycle;

import com.yuanjiaoc.common.domain.SuperUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月22日
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

  public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
      throws BeansException {
    if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
      // 把配置完成 superUser Bean 覆盖
      SuperUser superUser = new SuperUser();
      superUser.setAddress("HE");
      superUser.setName("super_");
      return superUser;
    }
    return null; // 保持 Spring IoC 容器的实例化操作
  }
}
