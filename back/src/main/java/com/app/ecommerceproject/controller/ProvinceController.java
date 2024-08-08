package com.app.ecommerceproject.controller;
import com.app.ecommerceproject.entity.Province;
import com.app.ecommerceproject.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public List<Province> getAllProvinces() {
        return provinceService.getAllProvinces();
    }
}

