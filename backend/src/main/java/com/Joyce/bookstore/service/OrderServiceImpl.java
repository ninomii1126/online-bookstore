package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.Order;
import com.Joyce.bookstore.dto.request.CreateOrderRequest;
import com.Joyce.bookstore.dto.request.TotalOrdersRequest;
import com.Joyce.bookstore.dto.request.TotalRevenueRequest;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import com.Joyce.bookstore.mapper.OrderMapper;
import com.Joyce.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public Long getTotalOrders(TotalOrdersRequest req) {
        if(req.getStartDate()==null && req.getEndDate()==null){
            return orderRepository.count();
        }

        // TO-DO: count orders by create date
        return null;
    }

    @Override
    public BigDecimal getTotalRevenue(TotalRevenueRequest req) {

        BigDecimal totalRevenue = orderRepository.findAll()
                .stream()
                .map(Order::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // TO-DO: count orders by create date

        return totalRevenue;
    }
}
