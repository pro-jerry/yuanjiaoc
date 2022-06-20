package com.yuanjiaoc.pattern.decorator.passport.old;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class SigninService implements ISigninService {

  @Override
  public ResultMsg regist(String username, String password) {
    return new ResultMsg(200, "注册成功", new Member());
  }

  @Override
  public ResultMsg login(String username, String password) {
    return null;
  }
}
