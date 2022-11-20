package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
@Component
public class UserRegisterSmsListener {

    // 通过注解实现监听器
    @EventListener
    @Order(2)
    public void handleUserEvent(UserDTO userDTO) {
        System.out.println("监听到用户注册，准备发送【短信】，user:" + userDTO.toString());
    }
}
