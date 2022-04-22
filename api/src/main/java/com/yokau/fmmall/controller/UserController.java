package com.yokau.fmmall.controller;

import com.yokau.fmmall.entity.User;
import com.yokau.fmmall.service.UserService;
import com.yokau.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
@ResponseBody
@RequestMapping("/user")
@Api(value = "提供用户登录和注册接口", tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "userName", value = "用户登录账号", required = true),
            @ApiImplicitParam(dataType = "String", name = "password", value = "用户登录密码", required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("userName") String userName,
                          @RequestParam("password") String password) {
        return userService.checkLogin(userName, password);
    }

//    如果 User 对象中成员变量信息以被文档注释，则不在需要注释User
//    以属性为单位传值
//    @ApiImplicitParam(name = "用户信息", required = true)

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "userName", value = "用户注册账号", required = true),
            @ApiImplicitParam(dataType = "String", name = "password", value = "用户注册密码", required = true)
    })
    @PostMapping("/register")
    public ResultVO register(String userName, String password) {
        return userService.userRegister(userName, password);
    }
}
