package com.yuanjiaoc.bean;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月06日
 */
public class BeanFactoryPostProcessorBean implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {

    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    genericBeanDefinition.setBeanClass(MyBean.class);
    genericBeanDefinition.getPropertyValues().add("strProp", "my string property");

    ((DefaultListableBeanFactory) beanFactory)
        .registerBeanDefinition("myBeanName", genericBeanDefinition);

    beanFactory
        .getBeanNamesIterator()
        .forEachRemaining(
            x -> {
              System.out.println("---->" + x);
            });
    Arrays.stream(beanFactory.getBeanDefinitionNames())
        .forEach(
            beanDefinition -> {
              //              System.out.println("--beanDefinition--->" + beanDefinition);
              if (beanDefinition.contains("internalConfigurationAnnotationProcessor")) {
                System.out.println("--beanDefinition1--->" + beanDefinition);
                BeanDefinition beanDefinition1 = beanFactory.getBeanDefinition(beanDefinition);
                System.out.println(beanDefinition1.getBeanClassName());
                System.out.println(beanDefinition1.getFactoryBeanName());
                System.out.println(beanDefinition1.getPropertyValues());
                System.out.println(beanDefinition1.getOriginatingBeanDefinition());
              }
            });
  }

  public static class MyBean {
    private String strProp;

    public void setStrProp(String strProp) {
      this.strProp = strProp;
    }

    public void doSomething() {
      System.out.println("from MyBean:  " + strProp);
    }
  }
}
