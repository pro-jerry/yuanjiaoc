package com.yuanjiaoc.sourcecoderead.mergebean;

import org.junit.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月06日
 */
//@RunWith(value = SpringJUnit4ClassRunner.class)
public class MergeBeanTest {

    @Test
    public void testMerge() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        RootBeanDefinition rootBean = new RootBeanDefinition();
        rootBean.setBeanClass(RootBean.class);
        rootBean.getPropertyValues().add("name", "张三");
        rootBean.getPropertyValues().add("age", "18");
        context.registerBeanDefinition("root0", rootBean);

        GenericBeanDefinition childBean = new GenericBeanDefinition();
        childBean.setBeanClass(ChildBean.class);
        childBean.getPropertyValues().add("name", "李四");
        childBean.setParentName("root0");
        context.registerBeanDefinition("child", childBean);

        context.refresh();

//        System.out.println(context.getBean(ChildBean.class));
    }
}
