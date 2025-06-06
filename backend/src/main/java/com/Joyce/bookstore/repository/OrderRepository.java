package com.Joyce.bookstore.repository;

import com.Joyce.bookstore.domain.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {

    List<Order> findByEmail(String email);


}
