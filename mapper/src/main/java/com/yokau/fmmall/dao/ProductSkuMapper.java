package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.ProductSku;
import com.yokau.fmmall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSkuMapper extends GeneralDao<ProductSku> {
    /**
     * 根据商品ID，查询当前商品所有套餐中价格最低的套餐
     * @param productId
     * @return
     */
    List<ProductSku> selectLowerestPriceByProductId(String productId);
}