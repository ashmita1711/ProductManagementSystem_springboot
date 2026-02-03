package com.example.productmanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductModel {
    @Id
    private String id;
    @NotBlank(message = "name cannot be null")
    private String name;
    private int price;
    private int stock;
    private String description;
}