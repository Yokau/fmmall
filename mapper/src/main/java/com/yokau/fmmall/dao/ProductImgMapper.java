package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.ProductImg;
import com.yokau.fmmall.general.GeneralDao;

import java.util.List;

public interface ProductImgMapper extends GeneralDao<ProductImg> {
    List<ProductImg> selectProductImgByProductId(String productId);
}