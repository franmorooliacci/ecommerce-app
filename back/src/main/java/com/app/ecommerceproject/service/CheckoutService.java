package com.app.ecommerceproject.service;

import com.app.ecommerceproject.dao.CustomerRepository;
import com.app.ecommerceproject.dto.PurchaseDto;
import com.app.ecommerceproject.dto.PurchaseResponseDto;
import com.app.ecommerceproject.entity.Customer;
import com.app.ecommerceproject.entity.Order;
import com.app.ecommerceproject.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Transactional
    public PurchaseResponseDto placeOrder(PurchaseDto purchaseDto) {

        // retrieve the order info from dto
        Order order = purchaseDto.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchaseDto.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with shippingAddress and billingAddress
        order.setShippingAddress(purchaseDto.getShippingAddress());
        order.setBillingAddress(purchaseDto.getBillingAddress());

        // populate customer with order
        Customer customer = purchaseDto.getCustomer();

        // check if this is an existing customer
        String theEmail = customer.getEmail();
        Customer customerFromFB = customerRepository.findByEmail(theEmail);
        if(customerFromFB != null) {
            customer = customerFromFB;
        }

        customer.add(order);

        // save to database
        customerRepository.save(customer);

        return new PurchaseResponseDto(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate random UUID number
        return UUID.randomUUID().toString();
    }
}
