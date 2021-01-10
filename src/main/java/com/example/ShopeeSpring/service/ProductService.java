package com.example.ShopeeSpring.service;

import com.example.ShopeeSpring.entity.Product;
import com.example.ShopeeSpring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product findById(String productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
