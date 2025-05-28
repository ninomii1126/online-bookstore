package com.Joyce.bookstore.mapper;

import com.Joyce.bookstore.domain.Order;
import com.Joyce.bookstore.dto.request.CreateOrderRequestVO;
import com.Joyce.bookstore.dto.response.CreateOrderResponse;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order toEntity(CreateOrderRequestVO req) {
        Order order = new Order();
        order.setName(req.getName());
        order.setEmail(req.getEmail());
        order.setAddress(req.getAddress());
        order.setPhone(req.getPhone());
        List<ObjectId> objectIds = req.getProductList()
                .stream()
                .map(ObjectId::new)
                .collect(Collectors.toList());
        order.setProductList(objectIds );
        order.setTotalPrice(req.getTotalPrice());
//        order.setCreatedAt(LocalDateTime.now());
        return order;
    }

    public static CreateOrderResponse toResponse(Order order) {
        CreateOrderResponse res = new CreateOrderResponse();
        res.setOrderId(order.getOrderId().toHexString());
        res.setName(order.getName());
        res.setEmail(order.getEmail());
        res.setAddress(order.getAddress());
        res.setPhone(order.getPhone());
        List<ObjectId> productList = order.getProductList();
        List<String> stringList = productList== null ? null : order.getProductList().stream().map(o -> o.toHexString()).collect(Collectors.toList());
        res.setProductList(stringList);
        res.setTotalPrice(order.getTotalPrice());
        return res;
    }
}
