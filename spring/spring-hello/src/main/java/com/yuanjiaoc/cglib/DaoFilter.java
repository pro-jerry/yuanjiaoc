package com.yuanjiaoc.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.CallbackFilter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月19日
 */
public class DaoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
