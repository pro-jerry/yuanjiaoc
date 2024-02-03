package com.yuanjiaoc.dao;

import com.yuanjiaoc.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {

    int add(UserRole userRole);
}
