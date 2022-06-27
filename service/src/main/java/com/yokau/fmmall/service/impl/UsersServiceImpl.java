package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.UsersMapper;
import com.yokau.fmmall.entity.Users;
import com.yokau.fmmall.service.UsersService;
import com.yokau.fmmall.utils.Base64Utils;
import com.yokau.fmmall.utils.MD5Utils;
import com.yokau.fmmall.vo.ResStatus;
import com.yokau.fmmall.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
//@Scope("singleton")  //Spring容器默认单例
//或者使 Controller 单例
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;


    @Override
    @Transactional //将以下操作定义成事务(数据库的隔离级别)
    public ResultVO usersRegister(String name, String password) {
        synchronized (this) {
//          1.根据用户查询，这个用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", name);
            List<Users> users = usersMapper.selectByExample(example);
            System.out.println(users.toString());
//          2.如果没有被注册则进行保存操作
            if (users.size() == 0) {
                String md5Password = MD5Utils.md5(password);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Password);
                user.setUserImg("img/default.img");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败", null);
                }
            } else {
                return new ResultVO(ResStatus.NO, "用户名已被注册！", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String password) {
        //1.根据账号查询用户信息
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);

        List<Users> users = usersMapper.selectByExample(example);

        //2.判断用户是否存在
        if (users.size() == 0) {
            // 用户名不存在
            return new ResultVO(ResStatus.NO, "登录失败，用户名不存在！", null);
        } else {
            String md5Password = MD5Utils.md5(password);
            if (users.get(0).getPassword().equals(md5Password)) {
                //如果登录验证成功，则需要生成令牌token(token就是按照特定规则生成的字符串)
                //使用JWT规则生成token字符串
                JwtBuilder builder = Jwts.builder();

                HashMap<String, Object> map = new HashMap<>();
                map.put("key1", "value1");
                map.put("key2", "value2");

                String token = builder.setSubject(name)                //主题设置token中携带的数据
                        .setIssuedAt(new Date())        //设置token的生成时间
                        .setId(users.get(0).getUserId().toString())//设置用户ID为token的ID
                        .setClaims(map)                 //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) //设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "yokau722900")
                        .compact();



//                String token = Base64Utils.encode(name + 123456);
                //验证成功
                return new ResultVO(ResStatus.OK, token, users.get(0));
            } else {
                //验证失败
                return new ResultVO(ResStatus.NO, "登录失败，密码错误！", null);
            }

        }
    }
}
