package com.assessment.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assessment.order_service.entity.Order;
import com.assessment.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    
    @PostMapping("/createorder")
    @ResponseBody
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        return this.orderService.createOrder(order);
    }


    @GetMapping("/getproducts")
    public String getProducts(){
        return null;
    }
}
