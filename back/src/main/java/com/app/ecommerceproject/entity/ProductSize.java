package com.app.ecommerceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_size")
@Getter
@Setter
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private int productId;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "stock")
    private int stock;
}
