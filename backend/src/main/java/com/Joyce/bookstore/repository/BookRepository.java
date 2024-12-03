package com.Joyce.bookstore.repository;

import com.Joyce.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findAll();
    @Query(value="{category:'?0'}")
    List<Book> findAll(String category);

//    void createBook(Book newBook);
}
