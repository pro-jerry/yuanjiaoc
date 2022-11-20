package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
@Component
public class UserRegisterEmailListener implements ApplicationListener<UserDTO> {

    public void onApplicationEvent(UserDTO userDTO) {
        System.out.println("监听到用户注册，准备发送【邮件】，user:" + userDTO.toString());
    }
}
