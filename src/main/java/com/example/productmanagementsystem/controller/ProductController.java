package com.example.productmanagementsystem.controller;

import com.example.productmanagementsystem.model.ProductModel;
import com.example.productmanagementsystem.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // create function api
    @PostMapping("/add-product")
    public ProductModel addProduct(@Valid @RequestBody ProductModel product) {
        return service.addProduct(product);
    }

    //display function api
    @GetMapping("/products")
    public List<ProductModel> getProducts() {
        return service.getProduct();
    }

    //updating function api
    @PutMapping("/update/{id}")
    public ProductModel updateProduct(@PathVariable String id, @RequestBody ProductModel product) {
        return service.updateProduct(id, product);
    }

    // delete function api
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
        return "product deleted successfully!";
    }



}