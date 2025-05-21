package com.Joyce.bookstore.controller;

import com.Joyce.bookstore.dto.request.CreateOrderRequestVO;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import com.Joyce.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequestVO requestVO){
        return new ResponseEntity<CreateOrderResponse>(orderService.createOrder(requestVO), HttpStatus.OK);
    }


}
