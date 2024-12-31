package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerControllerAPI {
    @Autowired
    private ICustomerService customerService;

//    danh sach khach hang
    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customerList = customerService.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        Customer customerObj = customer.get();
        return new ResponseEntity<>(customerObj, HttpStatus.OK);
    }
//    dung cho tao moi

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    xoa
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.remove(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            customer.setId(id);
            customerService.save(customer);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
