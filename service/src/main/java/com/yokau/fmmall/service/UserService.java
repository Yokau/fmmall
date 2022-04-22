package com.yokau.fmmall.service;

import com.yokau.fmmall.entity.User;
import com.yokau.fmmall.vo.ResultVO;

public interface UserService {
    //用户注册
    ResultVO userRegister(String name, String password);
    //用户登录
    ResultVO checkLogin(String name, String password);
}
