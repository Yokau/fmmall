package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.UserDao;
import com.yokau.fmmall.entity.User;
import com.yokau.fmmall.service.UserService;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public ResultVO checkLogin(String name, String password) {
        //1.根据账号查询用户信息
        User user = userDao.queryUserByName(name);

        //2.判断用户是否存在
        if(user == null){
            // 用户名不存在
            return new ResultVO(10001,"用户名不存在",null);
        }else{
            if(user.getUserPassword().equals(password)){
                //验证成功
                return new ResultVO(10000,"登录成功",user);
            }else{
                //验证失败
                return new ResultVO(10001,"密码错误",user);
            }

        }
    }
}
