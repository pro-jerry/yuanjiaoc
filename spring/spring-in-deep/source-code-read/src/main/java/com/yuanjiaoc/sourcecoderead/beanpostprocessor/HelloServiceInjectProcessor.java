package com.yuanjiaoc.sourcecoderead.beanpostprocessor;

import java.lang.reflect.Field;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月22日
 */
@Component
public class HelloServiceInjectProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> targetClazz = bean.getClass();
        Field[] targetField = targetClazz.getDeclaredFields();
        for (Field field : targetField) {
            if (field.isAnnotationPresent(RountingInjected.class)) {
                if (!field.getType().isInterface()) {
                    throw new BeanCreationException(
                            "RoutingInjected field must be declared as an interface:" + field.getName()
                                    + " @Class " + targetClazz.getName());
                }
                try {
                    this.handleRoutingInjected(field, bean, field.getType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }

    private void handleRoutingInjected(Field field, Object bean, Class type) throws IllegalAccessException {
        Map<String, Object> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if (candidates.size() == 1) {
            field.set(bean, candidates.values().iterator().next());
        } else if (candidates.size() == 2) {
            String injectVal = field.getAnnotation(RountingInjected.class).value();
            Object proxy = RoutingBeanProxyFactory.createProxy(injectVal, type, candidates);
            field.set(bean, proxy);
        } else {
            throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
        }
    }

}
