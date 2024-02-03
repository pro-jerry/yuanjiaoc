package com.yuanjiaoc.service.required;

import com.yuanjiaoc.entity.User;
import com.yuanjiaoc.service.ServiceTest;
import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class RequiredTest extends ServiceTest {

    @Resource
    private User1Service user1Service;

    @Resource
    private User2Service user2Service;

    @Test
    public void notransaction_exception_required_required(){
        User user1=new User();
        user1.setUserName("张三");
        user1Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Test
    public void notransaction_required_required_exception(){
        User user1=new User();
        user1.setUserName("张三");
        user1Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        user2Service.addRequiredException(user2);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_required(){
        User user1=new User();
        user1.setUserName("张三");
        user1Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception(){
        User user1=new User();
        user1.setUserName("张三");
        user1Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        user2Service.addRequiredException(user2);
    }

    @Transactional
    public void transaction_required_required_exception_try(){
        User user1=new User();
        user1.setUserName("张三");
        user1Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }
}
