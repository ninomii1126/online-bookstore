package com.Joyce.bookstore.controller;

import com.Joyce.bookstore.model.Book;
import com.Joyce.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/createBook")
    ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.createBook(book), HttpStatus.OK);
    }
}
