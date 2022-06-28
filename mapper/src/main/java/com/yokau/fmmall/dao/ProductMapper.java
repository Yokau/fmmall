package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.Product;
import com.yokau.fmmall.entity.ProductVO;
import com.yokau.fmmall.general.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDao<Product> {
    public List<ProductVO> selectRecommendProducts();

    /**
     * 查询指定一级类别下销量最高的6个商品
     * @param cid
     * @return
     */
    public List<ProductVO> selectTop6ByCategory(int cid);

    /**
     * 根据三级分类ID分页查询商品信息
     * @param cid 三级分类id
     * @param start 起始索引
     * @param limit 查询记录数
     * @return
     */
    public List<ProductVO> selectProductByCategoryId(@Param("cid") int cid,
                                                     @Param("start") int start,
                                                     @Param("limit") int limit);


}