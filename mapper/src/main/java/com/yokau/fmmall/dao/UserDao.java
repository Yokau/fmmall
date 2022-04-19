package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.User;


public interface UserDao {
    public User queryUserByName(String name);
}
