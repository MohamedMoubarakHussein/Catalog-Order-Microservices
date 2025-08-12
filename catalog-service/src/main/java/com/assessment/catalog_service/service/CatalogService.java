package com.assessment.catalog_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assessment.catalog_service.entity.CreateOrderEvent;
import com.assessment.catalog_service.entity.Product;
import com.assessment.catalog_service.repository.CatalogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogService {
    
    private final CatalogRepository catalogRepository;


    public List<Product> getAllProducts() {
       return this.catalogRepository.findAll();
    }

    public Product getProductById(int id) {
        return this.catalogRepository.findById(id);
    }

    public void updateProduct(CreateOrderEvent order) {
        Optional<Product> opProduct = this.catalogRepository.findById(order.getId());
        if(opProduct.isPresent()) {
            Product product = opProduct.get();
            product.setStock(product.getStock() - order.getStock());
            if(product.getStock() < 0) {
                return;
            }
            this.catalogRepository.save(product);
        }
    }

}
