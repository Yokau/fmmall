package com.yokau.fmmall.service.job;

import com.github.wxpay.sdk.WXPay;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yokau.fmmall.dao.OrdersMapper;
import com.yokau.fmmall.entity.Orders;

import com.yokau.fmmall.service.OrderService;
import com.yokau.fmmall.service.config.MyPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.annotation.Order;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderTimeoutCheckJob {

    @Autowired
    private MyPayConfig myPayConfig;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderService orderService;
    WXPay wxPay = new WXPay(myPayConfig);

    @Scheduled(cron = "0 0/1 * * * ?")
    public void checkAndCloseOrder() throws Exception {
        // 1.查询超过30min订单状态依然为待支付状态的订单
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        // 查找所有订单状态为1，订单时间超过30min的订单
        criteria.andEqualTo("status", "1");
        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
        criteria.andLessThan("createTime", time);

        List<Orders> ordersList = ordersMapper.selectByExample(example);

        // 2. 访问微信平台接口，确认当前订单最终支付状态
        System.out.println("size : " + ordersList.size());
        for (int i = 0; i < ordersList.size(); i++) {
            Orders order = ordersList.get(i);
            HashMap<String, String> params = new HashMap<>();
            params.put("out_trade_no", order.getOrderId());
            System.out.println("order.getOrderId()  " + order.getOrderId());
            if (!params.isEmpty() && !order.getOrderId().isEmpty()) {
                Map<String, String> resp = wxPay.orderQuery(params);
                String respStatu = resp.get("trade_state");
                if ("SUCCESS".equalsIgnoreCase(respStatu)) {
                    //2.1 如果订单已经支付，则修改订单状态为"代发货/已支付"  status = 2
                    Orders updateOrder = new Orders();
                    updateOrder.setOrderId(order.getOrderId());
                    updateOrder.setStatus("2");
                    ordersMapper.updateByPrimaryKeySelective(updateOrder);
                } else if ("NOTPAY".equalsIgnoreCase(respStatu)) {
                    //2.2 如果确实未支付 则取消订单：
                    //  a.向微信支付平台发送请求，关闭当前订单的支付链接
                    Map<String, String> closeResponseMap = wxPay.closeOrder(params);

                    // 关闭订单
                    orderService.closeOrder(order.getOrderId());
                }
            }

        }


    }

}
