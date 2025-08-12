package com.assessment.order_service.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Order {
    private Integer id;
    private double quantity;
}
