package com.yuanjiaoc.sourcecoderead.event;

import org.springframework.context.ApplicationListener;

/**
 * 用户注册成功给用户生成推荐商品.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年11月08日
 */
public class RecommendListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String) userRegisterEvent.getSource();
    }
}
