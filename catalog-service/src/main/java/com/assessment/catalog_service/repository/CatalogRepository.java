package com.assessment.catalog_service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.catalog_service.entity.Product;

@Repository
public interface CatalogRepository extends CrudRepository<Product , Integer> {
    public List<Product> findAll();
    public Product findById(int id);
}
