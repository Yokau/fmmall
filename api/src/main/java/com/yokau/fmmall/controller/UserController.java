package com.yokau.fmmall.controller;

import com.yokau.fmmall.service.UserService;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public ResultVO login(String name, String password){
        return userService.checkLogin(name, password);
    }
}
