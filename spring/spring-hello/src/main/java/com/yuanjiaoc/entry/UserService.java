package com.yuanjiaoc.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
@Component
public class UserService {

  @Autowired private MailService mailService;

  private final List<User> users =
      new ArrayList<>(
          Arrays.asList(
              new User(1L, "aaa", "aaa@mszlu.com", "123456"),
              new User(2L, "bbb", "bbb@mszlu.com", "123456"),
              new User(3L, "ccc", "ccc@mszlu.com", "123456")));

  public void setMailService(MailService mailService) {
    this.mailService = mailService;
  }

  public void registerUser(String mail, String password, String nickname) {
    users.forEach(
        user -> {
          if (user.getMail().equalsIgnoreCase(mail)) {
            throw new RuntimeException("已经注册");
          }
        });
    User user = new User(null, mail, password, nickname);
    mailService.sendRegisterMail(user);
  }
}
