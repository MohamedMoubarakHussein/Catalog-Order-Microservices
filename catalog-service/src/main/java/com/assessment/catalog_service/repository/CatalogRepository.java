package com.assessment.catalog_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.catalog_service.entity.Product;

@Repository
public interface CatalogRepository extends CrudRepository<Product , Integer> {
    
}
