package com.app.ecommerceproject.dao;

import com.app.ecommerceproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String theEmail);
}
