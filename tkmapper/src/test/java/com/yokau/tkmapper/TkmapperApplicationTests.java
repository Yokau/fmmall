package com.yokau.tkmapper;

import com.yokau.tkmapper.beans.User;
import com.yokau.tkmapper.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;


@SpringBootTest
class TkmapperApplicationTests {

    @Autowired
    @Resource
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("史桂林");
        user.setUserPassword("23333333");
        user.setUserImg("img/default.png");
        user.setUserRegtime(new Date());
        user.setUserModtime(new Date());
        int i = userDao.insert(user);
        System.out.println("i : " + i);
    }

}
