package com.yokau.fmmall.service;

import com.yokau.fmmall.entity.Orders;
import com.yokau.fmmall.vo.ResultVO;

import java.sql.SQLException;
import java.util.Map;

public interface OrderService {

    Map<String, String> addOrder(String cids, Orders order) throws SQLException;

    int updateOrderStatus(String orderId, String status);

    ResultVO getOrderById(String orderId);

    void closeOrder(String orderId);

    ResultVO listOrders(String userId, String status, int pageNum, int limit);


}
