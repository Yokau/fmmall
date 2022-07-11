package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.ShoppingCart;
import com.yokau.fmmall.entity.ShoppingCartVO;
import com.yokau.fmmall.general.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends GeneralDao<ShoppingCart> {
    List<ShoppingCartVO> selectShopcartByUserId(int userId);

    int updateCartnumByCartid(@Param("cartId") int cartId,
                              @Param("cartNum") int cartNum);


    List<ShoppingCartVO> selectShopcartByCids(@Param("cids") List<Integer> cids);
}