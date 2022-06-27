package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.ProductMapper;
import com.yokau.fmmall.entity.ProductVO;
import com.yokau.fmmall.service.ProductService;
import com.yokau.fmmall.vo.ResStatus;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "SUCCESS", productVOS);
        return resultVO;
    }
}
