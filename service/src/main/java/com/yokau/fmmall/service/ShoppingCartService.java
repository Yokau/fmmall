package com.yokau.fmmall.service;

import com.yokau.fmmall.entity.ShoppingCart;
import com.yokau.fmmall.vo.ResultVO;

import java.util.List;

public interface ShoppingCartService {

    ResultVO addShoppingCart(ShoppingCart cart);

    ResultVO listShoppingCartsByUserId(int userId);

    ResultVO updateCartNum(int cartId,int cartNum);

    ResultVO listShoppingCartsByCids(String cids);

}
