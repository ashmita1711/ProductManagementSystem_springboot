package com.example.productmanagementsystem.repository;

import com.example.productmanagementsystem.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {

}