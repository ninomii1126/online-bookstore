package com.Joyce.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document("book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @Field("_id")
    private ObjectId id;
    private String title;
    private String isbn;

    private String author;
    private String description;

    private List<String> category;

    private Date publishDate;

    private Boolean trending;

    private String coverImage;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private Date createAt;

}
