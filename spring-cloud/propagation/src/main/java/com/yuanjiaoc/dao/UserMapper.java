package com.yuanjiaoc.dao;

import com.yuanjiaoc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insertUser(User user);

    User getByUserNameAndPassword(User user);
}
