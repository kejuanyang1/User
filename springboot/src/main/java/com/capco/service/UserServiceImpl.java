package com.capco.service;

import com.capco.dao.UserDAO;
import com.capco.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(User user){
        User userDB = userDAO.findByUserName(user.getName());
        if(!ObjectUtils.isEmpty(userDB)){
           if(userDB.getPassword().equals(user.getPassword())){
               return userDB;
           }
           else{
               throw new RuntimeException("密码输入错误！");
           }
        }
        else{
            throw new RuntimeException("用户名不存在！");
        }
    }


    @Override
    public void register(User user) {

        //判断用户名是否存在
        User userDB = userDAO.findByUserName(user.getName());
        if (userDB == null) {
            userDAO.save(user);
        } else {
            throw new RuntimeException("用户名已存在");
        }
    }

}
