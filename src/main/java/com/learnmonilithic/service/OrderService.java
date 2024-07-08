package com.learnmonilithic.service;


import com.learnmonilithic.entity.Order;
import com.learnmonilithic.payload.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getOrders(OrderRequest orderRequest);
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    void deleteOrder(Long orderId);
}
