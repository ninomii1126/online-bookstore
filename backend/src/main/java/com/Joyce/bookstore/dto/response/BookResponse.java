package com.Joyce.bookstore.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BookResponse {
    private String id;
    private String title;
    private String author;
    private Date publishDate;
    private  String description;

    private List<String> category;

    private Boolean trending;

    private String coverImage;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private Date CreateDate;

}
