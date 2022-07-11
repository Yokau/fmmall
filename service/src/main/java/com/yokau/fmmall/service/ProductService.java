package com.yokau.fmmall.service;

import com.yokau.fmmall.vo.ResultVO;

import javax.xml.transform.Result;

public interface ProductService {
    ResultVO listRecommendProducts();

    ResultVO getProductBasicInfo(String productId);

    ResultVO getProductParamsById(String productId);

    ResultVO getProductsByCategoryId(Integer categoryId, Integer pageNum, Integer limit);

    ResultVO listBrands(Integer categoryId);

    ResultVO searchProduct(String kw, Integer pageNum, Integer limit);

    ResultVO listBrands(String kw);


}
