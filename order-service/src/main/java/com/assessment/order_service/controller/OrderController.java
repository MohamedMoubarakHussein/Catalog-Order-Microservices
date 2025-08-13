package com.assessment.order_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assessment.order_service.entity.Order;
import com.assessment.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    
    @PostMapping("/createorder")
    public String createOrder(@ModelAttribute Order order , Model model) {
        model.addAttribute("orderEvent",  this.orderService.createOrder(order));
        model.addAttribute("order",  order);

        return "successedPage";
    }


    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", this.orderService.getProducts());
        return "main";
    }
}
