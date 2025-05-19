package com.Joyce.bookstore.service;

import com.Joyce.bookstore.model.Book;
import org.bson.types.ObjectId;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> getBooksByCategoryId(String id);

    Book createBook(Book newNook);

    Book getSingleBook(String id);

    Book updateBook(String id, Book book);

    String deleteBook(String id);
}
