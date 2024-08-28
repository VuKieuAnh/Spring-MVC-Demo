package com.codegym.controller;

import com.codegym.model.DTO.ICountCustomer;
import com.codegym.service.impl.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/provinces")
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
        Iterable<ICountCustomer> customers = provinceService.getCountCustomers();
        return ResponseEntity.ok(customers);
    }
}
