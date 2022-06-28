package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.ProductImg;
import com.yokau.fmmall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductImgMapper extends GeneralDao<ProductImg> {
    List<ProductImg> selectProductImgByProductId(String productId);
}