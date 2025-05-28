package com.Joyce.bookstore.service;

import com.Joyce.bookstore.dto.request.CreateOrderRequestVO;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;

import java.util.List;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequestVO requestVO);

    List<CreateOrderResponse> getOrdersByEmail(String email);
}
