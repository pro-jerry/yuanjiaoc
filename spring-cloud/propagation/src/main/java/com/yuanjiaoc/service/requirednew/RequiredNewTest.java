package com.yuanjiaoc.service.requirednew;

import com.yuanjiaoc.entity.User;
import com.yuanjiaoc.service.ServiceTest;
import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class RequiredNewTest extends ServiceTest {

    @Resource
    private User3Service user3Service;

    @Resource
    private User4Service user4Service;

    @Test
    public void notransaction_exception_requiresNew_requiresNew(){
        User user1 = new User();
        user1.setUserName("张三");
        user3Service.addRequiresNew(user1);

        User user2 = new User();
        user2.setUserName("李四");
        user3Service.addRequiresNew(user2);
        throw new RuntimeException();

    }

    @Test
    public void notransaction_requiresNew_requiresNew_exception(){
        User user1=new User();
        user1.setUserName("张三");
        user4Service.addRequiresNew(user1);

        User user2=new User();
        user2.setUserName("李四");
        user4Service.addRequiresNewException(user2);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_requiresNew_requiresNew(){
        User user1=new User();
        user1.setUserName("张三");
        user3Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        user4Service.addRequiresNew(user2);

        User user3=new User();
        user3.setUserName("王五");
        user4Service.addRequiresNew(user3);
        throw new RuntimeException();
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNew_exception(){
        User user1=new User();
        user1.setUserName("张三");
        user3Service.addRequired(user1);

        User user2=new User();
        user2.setUserName("李四");
        user4Service.addRequiresNew(user2);

        User user3=new User();
        user3.setUserName("王五");
        user4Service.addRequiresNewException(user3);
    }
}
