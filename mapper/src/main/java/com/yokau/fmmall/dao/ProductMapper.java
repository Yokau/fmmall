package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.Product;
import com.yokau.fmmall.entity.ProductVO;
import com.yokau.fmmall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDao<Product> {
    List<ProductVO> selectRecommendProducts();
}