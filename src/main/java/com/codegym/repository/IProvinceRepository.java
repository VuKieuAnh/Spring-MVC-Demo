package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
//    an tu dong tat cac phuong thuc crud
    @Query(nativeQuery = true, value = "select name, count(c.firstName) as number from province left join customer_cg.customer c on province.id = c.province_id group by province.name;")
    Iterable<ICountCustomer> getCountCustomers();

    Page<Province> findAll(Pageable pageable);


    @Query(nativeQuery = true, value = "select name, count(c.id) as number from province left join customer_cg.customer c on province.id = c.province_id group by name;")
    Iterable<ICountCustomer> getNumberOfProvince();

    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "call deleteprovincebyid(:id)")
    void deleteProvinceById(@Param("id") Long id);

//query de sua du lieu
    @Modifying
//query de thuc hien nhieu thao tac
    @Transactional
    @Query(nativeQuery = true, value = "call deleteprovincebyid(:id)")
    void xoaTinhTheoId(@Param("id") Long id);


//    Province getProvincesByNema(String name);
}
