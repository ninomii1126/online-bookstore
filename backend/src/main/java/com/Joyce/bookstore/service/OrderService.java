package com.Joyce.bookstore.service;

import com.Joyce.bookstore.dto.request.CreateOrderRequest;
import com.Joyce.bookstore.dto.request.TotalOrdersRequest;
import com.Joyce.bookstore.dto.request.TotalRevenueRequest;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import com.Joyce.bookstore.dto.response.MonthlySalesResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest req);

    List<CreateOrderResponse> getOrdersByEmail(String email);

    Long getTotalOrders(TotalOrdersRequest req);

    BigDecimal getTotalRevenue(TotalRevenueRequest req);

    MonthlySalesResponse getMonthlyRevenue();
}
