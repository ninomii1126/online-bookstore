package com.Joyce.bookstore.service;

import com.Joyce.bookstore.model.Book;
import com.Joyce.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByCategoryId(String id) {
        return getBooksByCategoryId(id);
    }
}
