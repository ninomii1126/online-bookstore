package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.Book;
import com.Joyce.bookstore.dto.response.BookResponse;
import com.Joyce.bookstore.mapper.BookMapper;
import com.Joyce.bookstore.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookResponse> getAllBooks() {
        List<BookResponse> res = new ArrayList<>();
        for(Book book: bookRepository.findAll()){
            res.add(BookMapper.toResponse(book));
        }
        return res;
    }

    @Override
    public List<Book> getBooksByCategoryId(String id) {
        return getBooksByCategoryId(id);
    }

    @Override
    public Book createBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Book getSingleBook(String id) {
        System.out.println("Received ID string in getSingleBook: " + id);
        try {
            ObjectId objectId = new ObjectId(id);
            System.out.println("Searching for ObjectId: " + objectId.toHexString());

            if(bookRepository.findById(objectId).isPresent()){
                System.out.println("Found book with ID: " + id);
                return bookRepository.findById(objectId).get();
            }

            System.out.println("No data found for ID: " + id);
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid ID string format received: " + id);
            return null;
        }
    }

    @Override
    public Book updateBook(String id, Book updateBook) {
        ObjectId objectId = new ObjectId(id);
        return (
                bookRepository.findById(objectId).map(existingBook->{
                    existingBook.setTitle(updateBook.getTitle());
                    existingBook.setDescription(updateBook.getDescription());
                    existingBook.setCategory(updateBook.getCategory());
                    existingBook.setTrending(updateBook.getTrending());
                    existingBook.setCoverImage(updateBook.getCoverImage());
                    existingBook.setOldPrice(updateBook.getOldPrice());
                    existingBook.setNewPrice(updateBook.getNewPrice());
                    existingBook.setCreateAt(new Date());

                    return bookRepository.save(existingBook);
                }).orElseThrow(()-> new RuntimeException("Book not found with id: " + id))
                );
    }

    @Override
    public String deleteBook(String id) {
        try{
            ObjectId objectId = new ObjectId(id);
            bookRepository.deleteById(objectId);
            return "Book with id: "+id +" deleted successfully";
        }catch (Exception e){
            return "Error occurred while deleting book with ID " + id + ": " + e.getMessage();
        }
    }

    @Override
    public Long getTrendingBooks() {
        return bookRepository.countByTrendingTrue();
    }

    @Override
    public Long getTotalBooksCount() {
        return bookRepository.count();
    }


}
