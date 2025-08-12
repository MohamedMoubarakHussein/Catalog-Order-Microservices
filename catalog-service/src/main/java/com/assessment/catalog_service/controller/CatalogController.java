package com.assessment.catalog_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.catalog_service.entity.Product;
import com.assessment.catalog_service.service.CatalogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
       return this.catalogService.getAllProducts();
    }   
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(int id) {
        return this.catalogService.getProductById(id);
    }

}
