package com.assessment.order_service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.order_service.entity.CreateOrderEvent;
import com.assessment.order_service.entity.Order;
import com.assessment.order_service.entity.Product;
import com.assessment.order_service.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final EventProducer eventProducer;
    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    public ResponseEntity<String> createOrder(Order order) {
        this.orderRepository.save(order);
        CreateOrderEvent createOrderEvent = new CreateOrderEvent();
        createOrderEvent.setOrderId(UUID.randomUUID().toString());
        createOrderEvent.setProductId(order.getId());
        createOrderEvent.setQuantity(order.getQuantity());
        createOrderEvent.setTimestamp(System.currentTimeMillis());
        String orderAsJson = "";
        try {
            orderAsJson = this.objectMapper.writeValueAsString(createOrderEvent);
            this.eventProducer.sendMessage("order.created", orderAsJson);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("Error processing order creation");
        }
        return ResponseEntity.ok("Order created successfully "+ orderAsJson);
    }

    public List<Product> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/catalog/products";
        Product[] productsArray = restTemplate.getForObject(url, Product[].class);
        return Arrays.asList(productsArray);
    }
}
