package com.yuanjiaoc.pattern.decorator.passport.old;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public interface ISigninService {

  ResultMsg regist(String username, String password);

  /**
   * 登录的方法
   *
   * @param username
   * @param password
   * @return
   */
  ResultMsg login(String username, String password);
}
