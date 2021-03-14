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

    public Product findById(String productID) {
        try{
            return productRepository.findById(productID);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Product> getAll(String sortColumn, String sortType) {
        switch (sortType) {
            case "asc":
                return productRepository.getAll_ASC(sortColumn);
            case "desc":
                return productRepository.getAll_DESC(sortColumn);
            default:
                return productRepository.getAll();
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

    public Integer deleteById(String productID) {
        try{
            return productRepository.deleteById(productID);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer addProduct(Product product) {
        try{
            return productRepository.addProduct(product);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
