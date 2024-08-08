package com.app.ecommerceproject.service;

import com.app.ecommerceproject.dao.ProductSizeRepository;
import com.app.ecommerceproject.dto.ProductSizeDto;
import com.app.ecommerceproject.dto.SizeDto;
import com.app.ecommerceproject.entity.ProductSize;
import com.app.ecommerceproject.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    public List<ProductSizeDto> getProductSizesByProductId(int productId) {
        List<ProductSize> productSizes = productSizeRepository.findByProductId(productId);
        return productSizes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProductSizeDto convertToDto(ProductSize productSize) {
        Size size = productSize.getSize();
        SizeDto sizeDto = new SizeDto(size.getId(), size.getDescription());
        return new ProductSizeDto(productSize.getId(), productSize.getProductId(), productSize.getStock(), sizeDto);
    }
}
