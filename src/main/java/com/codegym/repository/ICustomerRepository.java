package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
//    Iterable<Customer> findAllByProvince1(Province province);

    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAllByLastName(String name);

    Iterable<Customer> findAllByFirstNameContaining(String firstName);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);

}
