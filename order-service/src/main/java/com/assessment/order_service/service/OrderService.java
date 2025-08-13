package com.assessment.order_service.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.order_service.entity.CreateOrderEvent;
import com.assessment.order_service.entity.Order;
import com.assessment.order_service.entity.Product;
import com.assessment.order_service.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final EventProducer eventProducer;
    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public CreateOrderEvent createOrder(Order order) {
        this.orderRepository.save(order);
        CreateOrderEvent createOrderEvent = new CreateOrderEvent();
        createOrderEvent.setOrderId(order.getOrderId());
        createOrderEvent.setProductId(order.getProductId());
        createOrderEvent.setQuantity(order.getQuantity());
        createOrderEvent.setTimestamp(System.currentTimeMillis());
        String orderAsJson = "";
        try {
            orderAsJson = this.objectMapper.writeValueAsString(createOrderEvent);
            this.eventProducer.sendMessage("order.created", orderAsJson);
        } catch (JsonProcessingException e) {
            return null; 
        }
        return createOrderEvent;
    }

    public List<Product> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://catalog-service:8081/catalog/products";
        Product[] productsArray = restTemplate.getForObject(url, Product[].class);
        return Arrays.asList(productsArray);
    }
}
