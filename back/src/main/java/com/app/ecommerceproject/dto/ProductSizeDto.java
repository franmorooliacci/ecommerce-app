package com.app.ecommerceproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSizeDto {

    private int id;
    private int productId;
    private int stock;
    private SizeDto sizeDto;

    public ProductSizeDto(int id, int productId, int stock, SizeDto sizeDto) {
        this.id = id;
        this.productId = productId;
        this.stock = stock;
        this.sizeDto = sizeDto;
    }
}
