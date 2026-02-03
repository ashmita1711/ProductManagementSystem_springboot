package com.example.productmanagementsystem.service;

import com.example.productmanagementsystem.model.ProductModel;
import com.example.productmanagementsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    //Create
    public ProductModel addProduct(ProductModel product) {
        return repository.save(product); //add function of repository
    }

    //display
    public List<ProductModel> getProduct() {
        return repository.findAll();
    }

    //update
    public ProductModel updateProduct(String id, ProductModel product ) {
        ProductModel existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Product found!"));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setDescription(product.getDescription());

        return repository.save(existingProduct);
    }

    // delete
    public void deleteProduct(String id) {
        ProductModel existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Product found!"));

        repository.delete(existingProduct);
    }

}