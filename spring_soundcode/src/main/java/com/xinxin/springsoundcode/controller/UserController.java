package com.xinxin.springsoundcode.controller;

import com.xinxin.springsoundcode.annotation.Autowired;
import com.xinxin.springsoundcode.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
