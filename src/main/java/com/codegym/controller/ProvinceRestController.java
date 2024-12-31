package com.codegym.controller;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.model.Province;
import com.codegym.service.impl.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin("*")
public class ProvinceRestController {
    @Autowired
    private ProvinceService provinceService;
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        provinceService.deleteProvinceById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity getAllProvinces() {
        Iterable<ProvinceDTO> customers = provinceService.countCustomerByProvice();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/list")
    public ResponseEntity getProvinces() {
        Iterable<Province> customers = provinceService.findAll();
        return ResponseEntity.ok(customers);
    }
}
