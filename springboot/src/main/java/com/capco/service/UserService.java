package com.capco.service;

import com.capco.entity.User;

public interface UserService {

    //注册
    void register(User user);

    //登录
    User login(User user);

}
