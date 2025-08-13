package com.assessment.catalog_service.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assessment.catalog_service.entity.Product;
import com.assessment.catalog_service.repository.CatalogRepository;

import java.util.List;

@Configuration
public class AddExampleProduct {

    @Bean
    CommandLineRunner AddProducts(CatalogRepository repo) {
        return args -> repo.saveAll(List.of(
            new Product(null, "Laptop", 10, 1200.50),
            new Product(null, "Mouse", 50, 25.75),
            new Product(null, "Keyboard", 30, 45.00)
        ));
    }
}
