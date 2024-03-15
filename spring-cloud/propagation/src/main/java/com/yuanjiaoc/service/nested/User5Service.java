package com.yuanjiaoc.service.nested;

import com.yuanjiaoc.dao.UserMapper;
import com.yuanjiaoc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class User5Service {

    @Resource
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User user){
        userMapper.insertUser(user);
    }
}
