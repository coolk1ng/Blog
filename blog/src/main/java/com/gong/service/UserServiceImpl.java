package com.gong.service;


import com.gong.Until.MD5Utils;
import com.gong.mapper.UserMapper;
import com.gong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GongXiWu on 2021/05/25
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.checkUser(username, MD5Utils.toMD5(password));
    }
}
