package com.assessment.order_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventProducer {
     private final KafkaTemplate<String, String> kafkaTemplate;

      public void sendMessage(String topic, String message) {
        this.kafkaTemplate.send(topic, message);
           
    }
}


