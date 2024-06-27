package com.codegym.repository;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Long> {
//    an tu dong tat cac phuong thuc crud
    @Query(nativeQuery = true, value = "select name, count(c.firstName) as number from province left join customer_cg.customer c on province.id = c.province_id group by province.name;")
    Iterable<ICountCustomer> getCountCustomers();
}
