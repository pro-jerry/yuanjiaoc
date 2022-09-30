package com.yuanjiaoc.conversion;

import com.yuanjiaoc.common.domain.User;
import java.beans.PropertyEditor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 自定义 {@link PropertyEditor} 示例
 *
 * @author 何二白
 * @version 1.0
 * @see PropertyEditor
 * @since 2022年09月30日
 */
public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        // 创建并且启动 BeanFactory 容器，
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/property-editors-context.xml");

        // AbstractApplicationContext -> "conversionService" ConversionService Bean
        // -> ConfigurableBeanFactory#setConversionService(ConversionService)
        // -> AbstractAutowireCapableBeanFactory.instantiateBean
        // -> AbstractBeanFactory#getConversionService ->
        // BeanDefinition -> BeanWrapper -> 属性转换（数据来源：PropertyValues）->
        // setPropertyValues(PropertyValues) -> TypeConverter#convertIfNecessnary
        // TypeConverterDelegate#convertIfNecessnary  -> PropertyEditor or ConversionService

        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
