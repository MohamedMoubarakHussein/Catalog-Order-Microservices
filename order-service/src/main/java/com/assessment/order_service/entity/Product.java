package com.assessment.order_service.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private double stock;
    private double price;
}
