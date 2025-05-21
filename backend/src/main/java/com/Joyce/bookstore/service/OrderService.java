package com.Joyce.bookstore.service;

import com.Joyce.bookstore.dto.request.CreateOrderRequestVO;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequestVO requestVO);
}
