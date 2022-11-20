package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    public void register() {
        UserDTO userDTO = new UserDTO(this);
        userDTO.setAge(18);
        userDTO.setName("精灵王jinglingwang.cn");
        userDTO.setUserId(1001);
        System.out.println("register user");
        eventPublisher.publishEvent(userDTO);
    }
}
