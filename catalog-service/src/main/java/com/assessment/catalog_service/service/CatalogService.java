package com.assessment.catalog_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assessment.catalog_service.entity.CreateOrderEvent;
import com.assessment.catalog_service.entity.Product;
import com.assessment.catalog_service.repository.CatalogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogService {
    
    private final CatalogRepository catalogRepository;


    public ResponseEntity<List<Product>> getAllProducts() {
       return ResponseEntity.ok().body(this.catalogRepository.findAll());
    }

    public ResponseEntity<Product> getProductById(int id) {
         Optional<Product> opProduct = this.catalogRepository.findById(id);
         if(opProduct.isPresent()) {
            return ResponseEntity.ok().body(opProduct.get());
         } else {
            return ResponseEntity.notFound().build();
         }
    }

    public void updateProduct(CreateOrderEvent order) {
        Optional<Product> opProduct = this.catalogRepository.findById(order.getProductId());
        if(opProduct.isPresent()) {
            Product product = opProduct.get();
            product.setStock(product.getStock() - order.getQuantity());
            if(product.getStock() < 0) {
                return;
            }
            this.catalogRepository.save(product);
        }
    }

}
