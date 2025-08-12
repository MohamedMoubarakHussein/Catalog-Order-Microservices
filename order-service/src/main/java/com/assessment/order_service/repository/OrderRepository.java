package com.assessment.order_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.order_service.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    
}
