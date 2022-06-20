package com.yuanjiaoc.pattern.decorator.passport.upgrade;

import com.yuanjiaoc.pattern.decorator.passport.old.ISigninService;
import com.yuanjiaoc.pattern.decorator.passport.old.ResultMsg;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class SigninForThirdService implements ISiginForThirdService {

  private final ISigninService signin;

  public SigninForThirdService(ISigninService signin) {
    this.signin = signin;
  }

  @Override
  public ResultMsg regist(String username, String password) {
    return signin.login(username, password);
  }

  @Override
  public ResultMsg login(String username, String password) {
    return signin.regist(username, password);
  }

  @Override
  public ResultMsg loginForQQ(String id) {
    return null;
  }

  @Override
  public ResultMsg loginForWechat(String id) {
    return null;
  }

  @Override
  public ResultMsg loginForToken(String token) {
    return null;
  }

  @Override
  public ResultMsg loginForTelphone(String telphone, String code) {
    return null;
  }

  @Override
  public ResultMsg loginForRegist(String username, String passport) {
    return null;
  }
}
