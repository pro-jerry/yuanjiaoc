package com.yuanjiaoc.pattern.adapter.loginadapter.v2;

import com.yuanjiaoc.pattern.adapter.loginadapter.ResultMsg;
import com.yuanjiaoc.pattern.adapter.loginadapter.v1.service.SiginService;
import com.yuanjiaoc.pattern.adapter.loginadapter.v2.adapters.LoginAdapter;
import com.yuanjiaoc.pattern.adapter.loginadapter.v2.adapters.LoginForQQAdapter;
import com.yuanjiaoc.pattern.adapter.loginadapter.v2.adapters.LoginForTelAdapter;
import com.yuanjiaoc.pattern.adapter.loginadapter.v2.adapters.LoginForTokenAdapter;
import com.yuanjiaoc.pattern.adapter.loginadapter.v2.adapters.LoginForWechatAdapter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird {

  @Override
  public ResultMsg loginForQQ(String id) {
    return processLogin(id, LoginForQQAdapter.class);
  }

  @Override
  public ResultMsg loginForWechat(String id) {
    return processLogin(id, LoginForWechatAdapter.class);
  }

  @Override
  public ResultMsg loginForToken(String token) {
    return processLogin(token, LoginForTokenAdapter.class);
  }

  @Override
  public ResultMsg loginForTelphone(String telphone, String code) {
    return processLogin(telphone, LoginForTelAdapter.class);
  }

  @Override
  public ResultMsg loginForRegist(String username, String passport) {
    super.regist(username, passport);
    return super.login(username, passport);
  }

  private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {

    try {
      // 适配器不一定要实现接口
      LoginAdapter adapter = clazz.newInstance();
      // 判断传过来的适配器是否能处理指定的逻辑
      if (adapter.support(adapter)) {
        return adapter.login(key, adapter);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
