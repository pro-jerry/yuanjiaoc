package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册成功发送短信.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年11月08日
 */
@Component
public class NotifyUserListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String) userRegisterEvent.getSource();
    }
}
