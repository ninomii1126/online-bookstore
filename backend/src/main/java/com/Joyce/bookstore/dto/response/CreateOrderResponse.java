package com.Joyce.bookstore.dto.response;

import com.Joyce.bookstore.domain.Address;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Getter
@Setter

public class CreateOrderResponse {

    private ObjectId orderId;
    private String name;
    private String email;
    private Address address;
    private String phone ;

    private List<ObjectId> productList;
    private BigDecimal totalPrice;

    private Date createAt;

}
