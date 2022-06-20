package com.yuanjiaoc.pattern.adapter.loginadapter.v1;

import com.yuanjiaoc.pattern.adapter.loginadapter.v1.service.SigninForThirdService;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class SigninForThirdServiceTest {

  public static void main(String[] args) {
    SigninForThirdService service = new SigninForThirdService();

    // 不改变原来的代码，也要能够兼容新的需求
    // 还可以再加一层策略模式
    service.loginForQQ("sdfgdgfwresdf9123sdf");
  }
}
