package com.app.ecommerceproject.controller;

import com.app.ecommerceproject.dto.PurchaseDto;
import com.app.ecommerceproject.dto.PurchaseResponseDto;
import com.app.ecommerceproject.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("purchase")
    public PurchaseResponseDto placeOrder(@RequestBody PurchaseDto purchaseDto){
        PurchaseResponseDto purchaseResponseDto = checkoutService.placeOrder(purchaseDto);
        return purchaseResponseDto;
    }
}
