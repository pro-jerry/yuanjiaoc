package com.yuanjiaoc.bean.definition;

import com.yuanjiaoc.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class BeanDefinitionCreationDemo {
  public static void main(String[] args) {
    // 1.通过 BeanDefinitionBuilder 构建
    BeanDefinitionBuilder beanDefinitionBuilder =
        BeanDefinitionBuilder.genericBeanDefinition(User.class);
    // 通过属性设置
    beanDefinitionBuilder.addPropertyValue("id", 1L).addPropertyValue("name", "yuanjiaoc");
  }
}
