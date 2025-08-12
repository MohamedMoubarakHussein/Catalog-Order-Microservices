package com.assessment.catalog_service.entity;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private double stock;
    private double price;
}
