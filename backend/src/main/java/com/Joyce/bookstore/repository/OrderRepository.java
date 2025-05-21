package com.Joyce.bookstore.repository;

import com.Joyce.bookstore.domain.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {


}
