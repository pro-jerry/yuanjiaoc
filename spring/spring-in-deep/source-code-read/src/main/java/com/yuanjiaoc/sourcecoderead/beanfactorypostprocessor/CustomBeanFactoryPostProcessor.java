package com.yuanjiaoc.sourcecoderead.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月29日
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition myTestBeanBeanDefinition = beanFactory.getBeanDefinition("myTestBean");
        myTestBeanBeanDefinition.getPropertyValues().add("name", "1111");
    }

    static class MyTestBean {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyTestBean{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Bean
    public MyTestBean myTestBean() {
        MyTestBean myTestBean = new MyTestBean();
        myTestBean.setName("mima");
        return myTestBean;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomBeanFactoryPostProcessor.class);
        applicationContext.refresh();
        MyTestBean myTestBean = (MyTestBean) applicationContext.getBean("myTestBean");
        System.out.println(myTestBean.toString());
        applicationContext.close();
    }


}
