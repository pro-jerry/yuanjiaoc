package com.yuanjiaoc.sourcecoderead.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月02日
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private UserService userService;

    @Override
    public void query() {
        System.out.println(userService);
    }
}
