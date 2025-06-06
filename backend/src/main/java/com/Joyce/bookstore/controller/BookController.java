package com.Joyce.bookstore.controller;

import com.Joyce.bookstore.domain.Book;
import com.Joyce.bookstore.dto.response.BookResponse;
import com.Joyce.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    ResponseEntity<List<BookResponse>> getAllBooks(){
        return new ResponseEntity<List<BookResponse>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/getSingleBook/{id}")
    ResponseEntity<Book> getSingleBooks(@PathVariable String id){
//        ObjectId objectId = new ObjectId(id);
        return new ResponseEntity<Book>(bookService.getSingleBook(id), HttpStatus.OK);
    }

    @PostMapping("/createBook")
    ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.createBook(book), HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book){
        return new ResponseEntity<Book>(bookService.updateBook(id, book), HttpStatus.OK);
    }

    @DeleteMapping("deleteBook/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<String> deleteBook(@PathVariable String id){
        return new ResponseEntity<String>(bookService.deleteBook(id), HttpStatus.OK);
    }
}
