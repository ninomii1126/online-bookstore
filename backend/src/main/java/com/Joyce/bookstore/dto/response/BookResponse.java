package com.Joyce.bookstore.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
public class BookResponse {
    private String id;
    public   String title;
    private  String description;

    private String category;

    private Boolean trending;

    private String coverImage;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private Date CreateDate;

}
