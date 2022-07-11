package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.Orders;
import com.yokau.fmmall.entity.OrdersVO;
import com.yokau.fmmall.general.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper extends GeneralDao<Orders> {
    public List<OrdersVO> selectOrders(@Param("userId") String userId,
                                       @Param("status") String status,
                                       @Param("start") int start,
                                       @Param("limit") int limit);
}