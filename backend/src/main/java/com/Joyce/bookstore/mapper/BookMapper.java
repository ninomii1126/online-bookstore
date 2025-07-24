package com.Joyce.bookstore.mapper;

import com.Joyce.bookstore.domain.Book;
import com.Joyce.bookstore.dto.response.BookResponse;

public class BookMapper {
    public static BookResponse toResponse(Book book) {
        BookResponse res = new BookResponse();
        res.setId(book.getId().toHexString());
        res.setCategory(book.getCategory());
        res.setAuthor(book.getAuthor());
        res.setPublishDate(book.getPublishDate());
        res.setTitle(book.getTitle());
        res.setDescription(book.getDescription());
        res.setTrending(book.getTrending());
        res.setCoverImage(book.getCoverImage());
        res.setOldPrice(book.getOldPrice());
        res.setNewPrice(book.getNewPrice());
        res.setCreateDate(book.getCreateAt());
        return res;
    }
}
