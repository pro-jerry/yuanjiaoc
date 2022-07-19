package com.yuanjiaoc.dependency.injection;

import com.yuanjiaoc.common.domain.User;

/**
 * {@link User}的Holder类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月19日
 */
public class UserHolder {

  private User user;

  public UserHolder() {}

  public UserHolder(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "UserHolder{" + "user=" + user + '}';
  }
}
