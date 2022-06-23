package com.yuanjiaoc.selector;

import com.yuanjiaoc.bean.Role;
import com.yuanjiaoc.bean.User;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 测试@Import注解中使用ImportSelector 自定义逻辑，返回需要导入的组件
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
public class MyImportSelector implements ImportSelector {

  /**
   * 返回值为需要导入到容器中的bean的全类名数组.
   *
   * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
   * @return
   */
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {User.class.getName(), Role.class.getName()};
  }
}
