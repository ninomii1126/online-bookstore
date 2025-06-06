package com.Joyce.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document("order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    private ObjectId orderId;
    private String name;
    private String email;
    private Address address;
    private String phone ;

    private List<ObjectId> productList;
    private BigDecimal totalPrice;





}
