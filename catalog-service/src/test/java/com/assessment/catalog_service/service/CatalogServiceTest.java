package com.assessment.catalog_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.assessment.catalog_service.entity.Product;
import com.assessment.catalog_service.repository.CatalogRepository;

@ExtendWith(MockitoExtension.class)
public class CatalogServiceTest {
    
    @Mock
    CatalogRepository catalogRepository;

    @InjectMocks
    CatalogService catalogService;


    @Test
    void getAllProducts_returnsList() {
        when(catalogRepository.findAll()).thenReturn(List.of(new Product(), new Product()));

        ResponseEntity<List<Product>> result = catalogService.getAllProducts();

        assertEquals(2, result.getBody().size());
        verify(catalogRepository).findAll();
    }

    @Test
    void getProductById_found() {
        Product product = new Product();
        when(catalogRepository.findById(1)).thenReturn(Optional.of(product));

        ResponseEntity<Product> result = catalogService.getProductById(1);

        assertEquals(product, result.getBody());
    }

    @Test
    void getProductById_notFound() {
        when(catalogRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Product> result = catalogService.getProductById(1);

        assertEquals(404, result.getStatusCode().value());
    }

   
}
