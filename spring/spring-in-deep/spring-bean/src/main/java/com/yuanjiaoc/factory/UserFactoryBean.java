package com.yuanjiaoc.factory;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link com.yuanjiaoc.common.domain.User} Bean 的 {@link
 * org.springframework.beans.factory.FactoryBean} 实现
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class UserFactoryBean implements FactoryBean {

  @Override
  public Object getObject() throws Exception {
    return User.createUser();
  }

  @Override
  public Class<?> getObjectType() {
    return User.class;
  }
}
