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
        try{
            return productRepository.findById(productId);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Product> getAll(String sortColumn, int choice) {
        try{
            return productRepository.getAll(sortColumn,choice);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Product> getAll() {
        try{
            return productRepository.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer updateById(Product product) {
        try{
            return productRepository.updateById(product);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer deleteById(String productId) {
        try{
            return productRepository.deletedById(productId);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public  Integer addProduct(Product product) {
        try{
            return productRepository.addProduct(product);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
