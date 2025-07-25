package com.Joyce.bookstore.repository;

import com.Joyce.bookstore.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

        public Customer findByFirstName(String firstName);
        public List<Customer> findByLastName(String lastName);


}
