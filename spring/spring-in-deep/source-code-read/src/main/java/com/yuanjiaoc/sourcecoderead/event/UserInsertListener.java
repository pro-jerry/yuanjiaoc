package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 插入用户信息.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年11月08日
 */
@Component
public class UserInsertListener implements ApplicationListener<UserRegisterEvent> {


    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String) userRegisterEvent.getSource();
    }
}
