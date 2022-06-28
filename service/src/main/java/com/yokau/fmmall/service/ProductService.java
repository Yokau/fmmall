package com.yokau.fmmall.service;

import com.yokau.fmmall.vo.ResultVO;

public interface ProductService {
    ResultVO listRecommendProducts();

    ResultVO getProductBasicInfo(String productId);
}
