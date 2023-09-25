package com.example.springmongodemo.service;

import com.example.springmongodemo.bean.Customer;
import com.example.springmongodemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

    public Customer getCustomerById(String id){
        return repository.findById(id).get();
    }

    public Customer updateCustomer(Customer customer){
        Customer customerToUpdate = repository.findById(customer.getId()).get();

        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setAge(customer.getAge());
        customerToUpdate.setAddresses(customer.getAddresses());

        return repository.save(customerToUpdate);
    }

    public void deleteCustomer(String id){
        repository.deleteById(id);
    }


    public List<Customer> getCustomersBetweenAges(Integer minAge, Integer maxAge){
        return repository.findCustomersByAgeBetween(minAge, maxAge);
    }

    public List<Customer> getCustomersByLastNameStartsWith(Integer minAge, Integer maxAge){
        return repository.findCustomersByAgeBetween(minAge, maxAge);
    }




}
