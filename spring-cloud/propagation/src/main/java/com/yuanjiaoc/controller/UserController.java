package com.yuanjiaoc.controller;

import com.yuanjiaoc.entity.Response;
import com.yuanjiaoc.entity.User;
import com.yuanjiaoc.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("user/insert")
    public Response insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return Response.success(0);
    }

    @PostMapping("user/getByUserNameAndPassword")
    public Response getByUserNameAndPassword(@RequestBody User user) {
        User result = userService.getByUserNameAndPassword(user);
        return Response.success(result);
    }
}
