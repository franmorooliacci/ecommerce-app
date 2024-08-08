package com.app.ecommerceproject.controller;

import com.app.ecommerceproject.dto.ProductSizeDto;
import com.app.ecommerceproject.entity.ProductSize;
import com.app.ecommerceproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productSizes")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}/sizes")
    public List<ProductSizeDto> getProductSizesByProductId(@PathVariable Integer productId) {
        return productService.getProductSizesByProductId(productId);
    }
}
