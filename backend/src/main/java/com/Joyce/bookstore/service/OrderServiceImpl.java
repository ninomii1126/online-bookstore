package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.Order;
import com.Joyce.bookstore.dto.request.CreateOrderRequest;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import com.Joyce.bookstore.mapper.OrderMapper;
import com.Joyce.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest req) {
        Order entity = OrderMapper.toEntity(req);
        orderRepository.insert(entity);
        return OrderMapper.toResponse(entity);
    }

    @Override
    public List<CreateOrderResponse> getOrdersByEmail(String email) {
        List<Order> orders = orderRepository.findByEmail(email);
        if(orders.isEmpty()) return null;

        return orders.stream().map(o ->OrderMapper.toResponse(o)).collect(Collectors.toList());
    }
}
