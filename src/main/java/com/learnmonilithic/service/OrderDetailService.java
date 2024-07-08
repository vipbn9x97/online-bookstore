package com.learnmonilithic.service;

import com.learnmonilithic.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getOrderDetails();
    OrderDetail getOrderDetailById(Long orderDetailId);
    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
    void deleteOrderDetail(Long orderDetailId);
}
