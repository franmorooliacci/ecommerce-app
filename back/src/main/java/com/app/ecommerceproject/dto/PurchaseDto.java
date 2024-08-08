package com.app.ecommerceproject.dto;

import com.app.ecommerceproject.entity.Address;
import com.app.ecommerceproject.entity.Customer;
import com.app.ecommerceproject.entity.Order;
import com.app.ecommerceproject.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PurchaseDto {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
