package com.assessment.catalog_service.entity;

import lombok.Data;


@Data
public class CreateOrderEvent {
    private String orderId;
    private Integer productId;
    private double quantity;
    private Long timestamp; 
}
