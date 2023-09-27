package com.example.springmongodemo.controller;

import com.example.springmongodemo.bean.Customer;
import com.example.springmongodemo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;
    @PostMapping("/save")
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer){
        return new ResponseEntity<>(service.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<Customer> getCustomerById(@RequestParam String id){
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/getCustomers/age")
    public ResponseEntity<List<Customer>> getCustomersBetweenAges(@RequestParam Integer min,
                                                                  @RequestParam Integer max){
        return ResponseEntity.ok(service.getCustomersBetweenAges(min, max));
    }

    @GetMapping("/getCustomers/name")
    public ResponseEntity<List<Customer>> getCustomersLastNameStartsWith(@RequestParam String name){
        return ResponseEntity.ok(service.getCustomersByLastNameStartsWith(name));
    }

    @PutMapping("update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(service.updateCustomer(customer));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id){
        service.deleteCustomer(id);
        return ResponseEntity.ok("customer with id " + id + " was deleted successfully");
    }




}
