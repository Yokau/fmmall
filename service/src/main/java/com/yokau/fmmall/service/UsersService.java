package com.yokau.fmmall.service;

import com.yokau.fmmall.vo.ResultVO;

public interface UsersService {
    //用户注册
    ResultVO usersRegister(String name, String password);
    //用户登录
    ResultVO checkLogin(String name, String password);
}
