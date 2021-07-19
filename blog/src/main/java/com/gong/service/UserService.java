package com.gong.service;

import com.gong.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by GongXiWu on 2021/05/25
 */

public interface UserService {
    //根据用户名和密码查询用户
    User checkUser(String username, String password);
}
