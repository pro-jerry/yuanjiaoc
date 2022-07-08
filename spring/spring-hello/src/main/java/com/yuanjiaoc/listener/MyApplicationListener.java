package com.yuanjiaoc.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月08日
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

  /**
   * 容器发布事件触发该方法.
   *
   * @param event
   */
  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    System.out.println("收到事件：" + event);
  }
}
