package com.yokau.tkmapper.dao;

import com.yokau.tkmapper.beans.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class UserDaoTest {

    @Resource
    UserDao userDao;

    @Test
    public void selectByUserName(){
        List<User> users = userDao.selectByUserName("zhangsan");
        for(User user : users){
            System.out.println(user);
        }

    }
}