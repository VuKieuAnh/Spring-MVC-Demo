package com.codegym.repository;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
//    an tu dong tat cac phuong thuc crud
    @Query(nativeQuery = true, value = "select name, count(c.firstName) as number from province left join customer_cg.customer c on province.id = c.province_id group by province.name;")
    Iterable<ICountCustomer> getCountCustomers();

    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "call deleteprovincebyid(:id)")
    void deleteProvinceById(@Param("id") Long id);
}
