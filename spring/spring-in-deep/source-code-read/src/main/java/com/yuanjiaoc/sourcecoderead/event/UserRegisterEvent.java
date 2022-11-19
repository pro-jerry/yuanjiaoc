package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月08日
 */
public class UserRegisterEvent extends ApplicationEvent {


    public UserRegisterEvent(Person person) {
        super(person.toString());
    }
}
