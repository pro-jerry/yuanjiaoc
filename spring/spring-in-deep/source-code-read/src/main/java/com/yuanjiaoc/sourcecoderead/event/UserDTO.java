package com.yuanjiaoc.sourcecoderead.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
@Getter
@Setter
@ToString
public class UserDTO extends ApplicationEvent {

    private Integer userId;
    private String name;
    private Integer age;

    public UserDTO(Object source) {
        super(source);
    }
}
