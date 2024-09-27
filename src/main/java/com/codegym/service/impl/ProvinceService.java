package com.codegym.service.impl;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.model.Province;
import com.codegym.repository.IProvinceRepository;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

//danh day day la service
//tao bean thuoc tang service cho ung dung IoC
@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return iProvinceRepository.findAll(pageable);
    }

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
        return iProvinceRepository.getNumberOfProvince();
    };

    public void deleteProvinceById(Long id){
        iProvinceRepository.xoaTinhTheoId(id);
    };

    @Override
    public Iterable<ProvinceDTO> countCustomerByProvice() {
        return iProvinceRepository.countCustomerByProvice();
    }
}
