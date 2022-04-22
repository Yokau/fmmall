package com.yokau.fmmall.controller;

import com.yokau.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@Api(value = "提供商品添加、修改、删除及查询的相关接口",tags = "商品管理")
public class GoodsController {
    // 根据RESTful风格 ： 使用不同的请求方式表示不同的操作
    @PostMapping("/add")
    public ResultVO addGoods(){
        return null;
    }

    @DeleteMapping("/{goodsId}")
    public ResultVO deleteGoods(@PathVariable("goodsId") int goodsId){
        System.out.println("goodsId : " + goodsId);
        return new ResultVO(10000, "DELETE SUCCESS", null);
    }

    @PutMapping("/{goodsId}")
    public ResultVO updateGoods(){
        return null;
    }

    @GetMapping("/list")
    public ResultVO listGoods(){
        return null;
    }

    // http://localhost:7890/goods/1 goods1
    @GetMapping("/{goodsId}")
    public ResultVO getGoods(@PathVariable("goodsId") int goodsId){
        return null;
    }
}
