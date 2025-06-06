package com.Joyce.bookstore.service;

import com.Joyce.bookstore.dto.request.CreateOrderRequest;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;

import java.util.List;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest requestVO);

    List<CreateOrderResponse> getOrdersByEmail(String email);
}
