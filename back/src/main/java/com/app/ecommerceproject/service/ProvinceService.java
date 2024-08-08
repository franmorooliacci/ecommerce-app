package com.app.ecommerceproject.service;
import com.app.ecommerceproject.dao.ProvinceRepository;
import com.app.ecommerceproject.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }
}

