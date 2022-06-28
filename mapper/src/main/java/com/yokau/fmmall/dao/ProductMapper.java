package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.Product;
import com.yokau.fmmall.entity.ProductVO;
import com.yokau.fmmall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDao<Product> {
    List<ProductVO> selectRecommendProducts();

    /**
     * 查询指定一级类别下销量最高的6个商品
     * @param cid
     * @return
     */
    public List<ProductVO> selectTop6ByCategory(Integer cid);
}