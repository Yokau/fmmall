package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.OrderItem;
import com.yokau.fmmall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper extends GeneralDao<OrderItem> {
    List<OrderItem> listOrderItemsByOrderId(String orderId);
}