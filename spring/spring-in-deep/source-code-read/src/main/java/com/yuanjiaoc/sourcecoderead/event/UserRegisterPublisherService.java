package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月08日
 */
@Service
public class UserRegisterPublisherService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void insert(Person person) {

        UserRegisterEvent event = new UserRegisterEvent(person);
        applicationEventPublisher.publishEvent(event);
    }
}
