package com.yuanjiaoc.pattern.adapter.loginadapter.v1;

import com.yuanjiaoc.pattern.adapter.loginadapter.v1.service.SinginForThirdService;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class SiginForThirdServiceTest {

  public static void main(String[] args) {
    SinginForThirdService service = new SinginForThirdService();
    service.login("tom", "123456");
    service.loginForQQ("sdfasdfasf");
    service.loginForWechat("sdfasfsa");
  }
}
