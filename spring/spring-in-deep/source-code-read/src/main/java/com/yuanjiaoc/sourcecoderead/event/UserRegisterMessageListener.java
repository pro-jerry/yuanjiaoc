package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
@Component
public class UserRegisterMessageListener implements SmartApplicationListener {


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == UserDTO.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听到用户注册，给新用户发送【首条站内短消息】，user:" + event.toString());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
