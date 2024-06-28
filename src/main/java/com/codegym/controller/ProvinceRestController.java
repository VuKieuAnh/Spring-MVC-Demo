package com.codegym.controller;

import com.codegym.service.impl.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
