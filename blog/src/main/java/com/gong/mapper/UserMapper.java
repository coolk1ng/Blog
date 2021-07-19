package com.gong.mapper;

import com.gong.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by GongXiWu on 2021/05/25
 */
@Mapper
public interface UserMapper {
    //根据用户名和密码查询用户
    User checkUser(String username, String password);
}
