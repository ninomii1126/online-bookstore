package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.Order;
import com.Joyce.bookstore.dto.request.CreateOrderRequestVO;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import com.Joyce.bookstore.mapper.OrderMapper;
import com.Joyce.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequestVO req) {
        Order entity = OrderMapper.toEntity(req);
        orderRepository.insert(entity);
        return OrderMapper.toResponse(entity);
    }
}
