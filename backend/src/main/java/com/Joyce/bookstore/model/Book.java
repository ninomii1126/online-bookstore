package com.Joyce.bookstore.model;

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

@Document("book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @Field("_id")
    private ObjectId id;
    public   String title;
    private  String description;

    private String category;

    private Boolean trending;

    private String coverImage;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private Date CreateDate;

    public String title() {

        return this.title;
    }
}
