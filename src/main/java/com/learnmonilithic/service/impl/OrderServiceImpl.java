package com.learnmonilithic.service.impl;

import com.learnmonilithic.entity.Order;
import com.learnmonilithic.exception.ResourceNotFoundException;
import com.learnmonilithic.payload.request.OrderRequest;
import com.learnmonilithic.repository.OrderRepository;
import com.learnmonilithic.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders(OrderRequest orderRequest) {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Khong tim thay"));
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
