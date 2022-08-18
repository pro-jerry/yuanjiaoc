package com.yuanjiaoc.beanpropertyinit;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月18日
 */
public class MyInstantiationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

  @Override
  public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) {
    if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {

      final MutablePropertyValues propertyValues;
      if (pvs instanceof MutablePropertyValues) {
        propertyValues = (MutablePropertyValues) pvs;
      } else {
        propertyValues = new MutablePropertyValues();
      }

      if (propertyValues.contains("name")) {
        propertyValues.removePropertyValue("name");
        propertyValues.add("name", "abcd");
      }
      return propertyValues;
    }

    return null;
  }
}
