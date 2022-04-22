package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.UserDao;
import com.yokau.fmmall.entity.User;
import com.yokau.fmmall.service.UserService;
import com.yokau.fmmall.utils.MD5Utils;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
//@Scope("singleton")  //Spring容器默认单例
//或者使 Controller 单例
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;



    @Override
    @Transactional //将以下操作定义成事务(数据库的隔离级别)
    public ResultVO userRegister(String name, String password) {
        synchronized (this) {
//          1.根据用户查询，这个用户是否已经被注册
            User user = userDao.queryUserByName(name);
//          2.如果没有被注册则进行保存操作
            if (user == null) {
                String md5Password = MD5Utils.md5(password);
                user = new User();
                user.setUserName(name);
                user.setUserPassword(md5Password);
                user.setUserImg("img/default.img");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = userDao.insertUser(user);
                if (i > 0) {
                    return new ResultVO(10000, "注册成功", user);
                } else {
                    return new ResultVO(10001, "注册失败", user);
                }
            } else {
                return new ResultVO(10001, "用户名已被注册！", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String password) {
        //1.根据账号查询用户信息
        User user = userDao.queryUserByName(name);

        //2.判断用户是否存在
        if(user == null){
            // 用户名不存在
            return new ResultVO(10001,"登录失败，用户名不存在！",null);
        }else{
            String md5Password = MD5Utils.md5(password);
            if(user.getUserPassword().equals(md5Password)){
                //验证成功
                return new ResultVO(10000,"登录成功！",user);
            }else{
                //验证失败
                return new ResultVO(10001,"登录失败，密码错误！",null);
            }

        }
    }
}
