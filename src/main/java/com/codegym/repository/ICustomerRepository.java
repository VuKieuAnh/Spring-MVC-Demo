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

    Iterable<Customer> findAllByFirstNameContaining(String firstName);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
//    Page<Customer> findAllByFirstName1Containing(Pageable pageable, String name);

    Page<Customer> findAllByLastNameContaining(Pageable pageable, String name);
//    dinh nghia phuong thuc truy van
//    tim kiem theo lastName
//    danh sach
//    Phai viet dung theo goi y
//    Page<Customer> findAllByLastNameContaining(Pageable pageable, String name);
}
