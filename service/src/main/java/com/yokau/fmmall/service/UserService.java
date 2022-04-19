package com.yokau.fmmall.service;

import com.yokau.fmmall.entity.User;
import com.yokau.fmmall.vo.ResultVO;

public interface UserService {

    public ResultVO checkLogin(String name, String password);
}
