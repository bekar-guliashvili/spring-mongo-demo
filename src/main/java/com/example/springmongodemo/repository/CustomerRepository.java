package com.example.springmongodemo.repository;

import com.example.springmongodemo.bean.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findCustomersByAgeBetween(Integer min, Integer max);

    List<Customer> findCustomersByLastNameStartingWith(String name);

}
