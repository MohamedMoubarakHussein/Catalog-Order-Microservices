package com.assessment.catalog_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Product name cannot be null")
    @Column(length = 100 , unique = true)
    private String name;
    @DecimalMin(value = "0.0", message = "Value must be a zero or positive number")
    private double stock;
    @DecimalMin(value = "0.0", message = "Value must be a zero or positive number")
    private double price;
}
