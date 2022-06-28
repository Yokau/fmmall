package com.yokau.fmmall.controller;

import com.yokau.fmmall.entity.Users;
import com.yokau.fmmall.service.UsersService;
import com.yokau.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@ResponseBody
@RequestMapping("/user")
@Api(value = "提供用户登录和注册接口", tags = "用户管理")
@CrossOrigin
public class UserController {

    @Resource
    private UsersService usersService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户登录账号", required = true),
            @ApiImplicitParam(dataType = "String", name = "password", value = "用户登录密码", required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String userName,
                          @RequestParam("password") String password) {


        return usersService.checkLogin(userName, password);
    }

//    如果 User 对象中成员变量信息以被文档注释，则不在需要注释User
//    以属性为单位传值
//    @ApiImplicitParam(name = "用户信息", required = true)

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户注册账号", required = true),
            @ApiImplicitParam(dataType = "String", name = "password", value = "用户注册密码", required = true)
    })

    @PostMapping("/register")
    public ResultVO register(@RequestBody Users user) {
        return usersService.usersRegister(user.getUsername(), user.getPassword());
    }
}
