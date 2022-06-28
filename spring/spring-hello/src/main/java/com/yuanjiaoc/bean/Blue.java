package com.yuanjiaoc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 测试ApplicationContextAware接口.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
@Component
public class Blue implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("传入的ioc：" + applicationContext);
    this.applicationContext = applicationContext;
  }

  @Override
  public void setBeanName(String name) {
    System.out.println("当前bean的名字:" + name);
  }

  @Override
  public void setEmbeddedValueResolver(StringValueResolver resolver) {
    String resolveStringValue = resolver.resolveStringValue("你好${os.name} 年龄：#{20*18}");
    System.out.println("解析后的字符串为：" + resolveStringValue);
  }
}
