package com.yuanjiaoc.pattern.adapter.loginadapter.v1.service;

import com.yuanjiaoc.pattern.adapter.loginadapter.Member;
import com.yuanjiaoc.pattern.adapter.loginadapter.ResultMsg;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class SiginService {

  /**
   * 注册方法.
   *
   * @param username
   * @param password
   * @return
   */
  public ResultMsg regist(String username, String password) {
    return new ResultMsg(200, "注册成功", new Member());
  }

  /**
   * 登录方法
   *
   * @param username
   * @param password
   * @return
   */
  public ResultMsg login(String username, String password) {
    return null;
  }
}
