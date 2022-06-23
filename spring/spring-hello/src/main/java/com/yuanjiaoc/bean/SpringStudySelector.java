package com.yuanjiaoc.bean;

import com.yuanjiaoc.config.AppConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
public class SpringStudySelector implements ImportSelector, BeanFactoryAware {

  private BeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
    System.out.println(beanFactory);
    return new String[] {AppConfig.class.getName()};
  }
}
