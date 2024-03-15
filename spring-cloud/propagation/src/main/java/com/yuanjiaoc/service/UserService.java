package com.yuanjiaoc.service;

import com.yuanjiaoc.dao.UserMapper;
import com.yuanjiaoc.entity.User;
import com.yuanjiaoc.service.nested.User5Service;
import com.yuanjiaoc.service.nested.User6Service;
import com.yuanjiaoc.service.required.User1Service;
import com.yuanjiaoc.service.required.User2Service;
import com.yuanjiaoc.service.requirednew.User3Service;
import com.yuanjiaoc.service.requirednew.User4Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    private User1Service user1Service;

    @Resource
    private User2Service user2Service;

    @Resource
    private User3Service user3Service;

    @Resource
    private User4Service user4Service;

    @Resource
    private User5Service user5Service;

    @Resource
    private User6Service user6Service;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser(User user) {

        User user1=new User();
        user1.setUserName("张三");
        user5Service.addNested(user1);

        User user2=new User();
        user2.setUserName("李四");
        try {
            user6Service.addNestedException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }

    public User getByUserNameAndPassword(User user) {
        return userMapper.getByUserNameAndPassword(user);
    }
}
