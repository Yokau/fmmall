package com.yokau.fmmall.controller;

import com.yokau.fmmall.service.CategoryService;
import com.yokau.fmmall.service.IndexImgService;
import com.yokau.fmmall.service.ProductService;
import com.yokau.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@CrossOrigin
@RequestMapping("/index")
@Api(value = "提供用户登录和注册接口" , tags = "首页管理")
public class IndexController {
    @Autowired
    private IndexImgService indexImgService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/indeximg")
    @ApiOperation("首页轮播图接口")
    public ResultVO listIndexImgs(){
        return indexImgService.listIndexImgs();
    }

    @GetMapping("/category-list")
    @ApiOperation("商品分类的查询接口")
    public ResultVO listCategory(){
        return categoryService.listCategories();
    }

    @GetMapping("/list-recommends")
    @ApiOperation("查询推荐商品接口")
    public ResultVO listRecommendProducts() {
        return productService.listRecommendProducts();
    }

    @GetMapping("category-recommends")
    @ApiOperation("分类推荐接口")
    public ResultVO listRecommendProductsByCategory(){
        return categoryService.listFirstLevelCategories();
    }
}
