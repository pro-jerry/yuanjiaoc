package com.yuanjiaoc.pattern.adapter.loginadapter.v2.adapters;

import com.yuanjiaoc.pattern.adapter.loginadapter.ResultMsg;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class LoginForTokenAdapter implements LoginAdapter {

  @Override
  public boolean support(Object adapter) {
    return adapter instanceof LoginForTokenAdapter;
  }

  @Override
  public ResultMsg login(String id, Object adapter) {
    return null;
  }
}
