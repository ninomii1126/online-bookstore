package com.Joyce.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document("book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {

    @Id
    private  String id;
    public   String title;
    private  String description;

    private String category;
    private boolean trending;

    private String coverImage;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private Date CreateDate;

    public String title() {

        return this.title;
    }
}
