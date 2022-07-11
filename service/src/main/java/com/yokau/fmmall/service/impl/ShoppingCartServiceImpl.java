package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.ShoppingCartMapper;
import com.yokau.fmmall.entity.ShoppingCart;
import com.yokau.fmmall.entity.ShoppingCartVO;
import com.yokau.fmmall.service.ShoppingCartService;
import com.yokau.fmmall.vo.ResStatus;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public ResultVO addShoppingCart(ShoppingCart cart) {
        cart.setCartTime(sdf.format(new Date()));
        int i = shoppingCartMapper.insert(cart);
        if (i > 0) {
            return new ResultVO(ResStatus.OK, "SUCCESS", null);
        } else {
            return new ResultVO(ResStatus.NO, "FAIL", null);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVO listShoppingCartsByUserId(int userId) {
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByUserId(userId);
        ResultVO resultVO = new ResultVO(ResStatus.OK, "SUCCESS", list);
        return resultVO;
    }

    @Override
    public ResultVO updateCartNum(int cartId, int cartNum) {
        int i = shoppingCartMapper.updateCartnumByCartid(cartId, cartNum);
        if (i > 0) {
            return new ResultVO(ResStatus.OK, "UPDATE SUCCESS", null);
        } else {
            return new ResultVO(ResStatus.NO, "UPDATE FAIL", null);
        }
    }

    @Override
    public ResultVO listShoppingCartsByCids(String cids) {
        //使用tkmapper只能查询到某张表中拥有的字段，因此没法查询到商品名称、图片、单价等信息
        String[] arr = cids.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cartIds.add(Integer.parseInt(arr[i]));
        }
        System.out.println(cartIds);
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByCids(cartIds);
        ResultVO resultVO = new ResultVO(ResStatus.OK, "SUCCESS", list);
        return resultVO;
    }
}

