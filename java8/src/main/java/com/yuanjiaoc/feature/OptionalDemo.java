package com.yuanjiaoc.feature;

import java.util.Optional;
import org.junit.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月14日
 */
public class OptionalDemo {

  @Test
  public void testOptional() throws Exception {
    User user = null;
    User user1 = null;
    user = Optional.ofNullable(user).orElse(createUser());
    user = Optional.ofNullable(user).orElseGet(() -> createUser());
    Optional.ofNullable(user1).orElseThrow(() -> new Exception("用户不存在"));
    System.out.println(user.toString());
  }

  @Test
  public void testMap() {
    String city = Optional.ofNullable(createUser()).map(u -> u.getName()).toString();
  }

  @Test
  public void testIfPresent() {

    Optional.ofNullable(createUser()).ifPresent(u -> {});
  }

  public User createUser() {
    User user = new User();
    user.setName("zhangsan");
    return user;
  }
}
