package com.assessment.order_service.entity;


import lombok.Data;

@Data
public class CreateOrderEvent {
    private Integer orderId;
    private Integer productId;
    private double quantity;
    private Long timestamp; 
}
