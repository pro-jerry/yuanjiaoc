package com.yuanjiaoc.service;

import com.yuanjiaoc.dao.UserMapper;
import com.yuanjiaoc.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User getByUserNameAndPassword(User user) {
        return userMapper.getByUserNameAndPassword(user);
    }
}
