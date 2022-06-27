package com.yokau.fmmall.controller;


import com.yokau.fmmall.vo.ResultVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(value = "提供购物车业务相关接口", tags = "购物车管理")
public class ShopCartController {

    @GetMapping("/list")
    @ApiImplicitParam(dataType = "String", name = "token", value = "token授权令牌", required = true)
    public ResultVO listCarts(Integer userId) {
        System.out.println("userId: "+ userId);
        return null;
    }


}
