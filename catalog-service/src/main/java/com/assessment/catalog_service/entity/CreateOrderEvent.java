package com.assessment.catalog_service.entity;

import lombok.Data;

@Data
public class CreateOrderEvent {
    private Integer id;
    private double stock;
}
