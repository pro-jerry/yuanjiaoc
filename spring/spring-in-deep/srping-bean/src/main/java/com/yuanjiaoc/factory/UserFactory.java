package com.yuanjiaoc.factory;

import com.yuanjiaoc.common.domain.User;

/**
 * {@link User} 工厂类
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public interface UserFactory {

  default User createUser() {
    User user = new User();
    user.setId(100L);
    user.setName("yuan");
    return user;
  }
}
