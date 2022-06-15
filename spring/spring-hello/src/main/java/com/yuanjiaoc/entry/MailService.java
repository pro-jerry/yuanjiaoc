package com.yuanjiaoc.entry;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
@Component
public class MailService {

  public boolean sendRegisterMail(User user) {
    System.out.println(
        String.format(
            "%s 正在注册码神之路，您可以点击以下的链接完成注册 %s,如果不是你注册的，请忽略本邮件",
            user.getNickname(), "http://www.mszlu.com"));
    return true;
  }
}
