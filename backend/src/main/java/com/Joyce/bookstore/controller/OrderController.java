package com.Joyce.bookstore.controller;

import com.Joyce.bookstore.dto.request.CreateOrderRequest;
import com.Joyce.bookstore.dto.request.TotalOrdersRequest;
import com.Joyce.bookstore.dto.request.TotalRevenueRequest;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import com.Joyce.bookstore.dto.response.MonthlySalesResponse;
import com.Joyce.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest req){
        return new ResponseEntity<CreateOrderResponse>(orderService.createOrder(req), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    ResponseEntity<List<CreateOrderResponse>> getOrdersByEmail(@PathVariable String email){
        return new ResponseEntity<List<CreateOrderResponse>>(orderService.getOrdersByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/totalCount")
    ResponseEntity<Long> getTotalOrders(TotalOrdersRequest req){
        return new ResponseEntity<Long>(orderService.getTotalOrders(req), HttpStatus.OK);
    }

    @PostMapping("/totalRevenue")
    ResponseEntity<BigDecimal> getTotal(TotalRevenueRequest req){
        return new ResponseEntity<BigDecimal>(orderService.getTotalRevenue(req), HttpStatus.OK);
    }

    @GetMapping("/monthlyRevenue")
    ResponseEntity<MonthlySalesResponse> getMonthlyRevenue(){
        return new ResponseEntity<MonthlySalesResponse>(orderService.getMonthlyRevenue(), HttpStatus.OK);
    }

}
