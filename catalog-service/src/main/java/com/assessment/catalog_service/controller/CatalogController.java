package com.assessment.catalog_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.catalog_service.entity.Product;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    

    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return null;
    }   
    
    @GetMapping("/products/{id}")
    public Product getProductById(String id) {
        return null;
    }

}
