package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //用户注册
    int insertUser(User user);
    //根据用户名查询用户信息
    User queryUserByName(String name);
}
