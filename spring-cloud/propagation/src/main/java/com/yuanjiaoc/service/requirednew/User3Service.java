package com.yuanjiaoc.service.requirednew;

import com.yuanjiaoc.dao.UserMapper;
import com.yuanjiaoc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class User3Service {


    @Resource
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User user){
        userMapper.insertUser(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User user){
        userMapper.insertUser(user);
    }
}
