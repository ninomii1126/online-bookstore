package com.Joyce.bookstore.service;

import com.Joyce.bookstore.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> getBooksByCategoryId(String id);

    Book createBook(Book newNook);
}
