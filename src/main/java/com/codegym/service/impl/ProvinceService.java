package com.codegym.service.impl;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.Province;
import com.codegym.repository.IProvinceRepository;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//danh day day la service
//tao bean thuoc tang service cho ung dung IoC
//@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }

    public Iterable<ICountCustomer> getCountCustomers(){
        return iProvinceRepository.getCountCustomers();
    };

}
