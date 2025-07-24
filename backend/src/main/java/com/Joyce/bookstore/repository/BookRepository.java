package com.Joyce.bookstore.repository;

import com.Joyce.bookstore.domain.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, ObjectId> {

    List<Book> findAll();
    @Query(value="{category:'?0'}")
    List<Book> findAll(String category);
    Optional<Book> findById(ObjectId id);

    Long countByTrendingTrue();

    Boolean existsByIsbn(String isbn);

    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);

    List<Book> findByTitleContainingIgnoreCase(String title);

    @Query("{ '$or': [ " +
            "  { 'title': { $regex: ?0, $options: 'i' } }, " +
            "  { 'author': { $regex: ?0, $options: 'i' } } " +
            "] }")
    List<Book> searchByExactWordRegex(String wordRegex);

}
