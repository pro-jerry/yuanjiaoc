package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月20日
 */
public class MySpringEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param message 事件消息
     */
    public MySpringEvent(String message) {
        super(message);
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    public String getMessage() {
        return getSource();
    }
}
