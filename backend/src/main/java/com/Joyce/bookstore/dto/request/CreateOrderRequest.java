package com.Joyce.bookstore.dto.request;

import com.Joyce.bookstore.domain.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderRequest {
    private String name;
    private String email;
    private Address address;
    private String phone ;

    private List<String> productList;
    private BigDecimal totalPrice;
    private Date createAt;

}
