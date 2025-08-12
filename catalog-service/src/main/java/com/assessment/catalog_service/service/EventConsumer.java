package com.assessment.catalog_service.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.assessment.catalog_service.entity.CreateOrderEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventConsumer {

    private final CatalogService catalogService;

    @KafkaListener(topics = "order.created")
    public void consume(ConsumerRecord<String,String> consumRecord) throws JsonMappingException, JsonProcessingException{
        String message = consumRecord.value();
        ObjectMapper objectMapper = new ObjectMapper();
        CreateOrderEvent Product = objectMapper.readValue(message, CreateOrderEvent.class);
        this.catalogService.updateProduct(Product);
    }
}
