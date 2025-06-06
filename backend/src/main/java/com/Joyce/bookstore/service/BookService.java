package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.Book;
import com.Joyce.bookstore.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    List<BookResponse> getAllBooks();

    List<Book> getBooksByCategoryId(String id);

    Book createBook(Book newNook);

    Book getSingleBook(String id);

    Book updateBook(String id, Book book);

    String deleteBook(String id);
}
