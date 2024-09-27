package com.codegym.service;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.model.Province;

public interface IProvinceService extends IGenerateService<Province> {
    Iterable<ICountCustomer> getCountCustomers();
    void deleteProvinceById(Long id);
    Iterable<ProvinceDTO> countCustomerByProvice();
}
