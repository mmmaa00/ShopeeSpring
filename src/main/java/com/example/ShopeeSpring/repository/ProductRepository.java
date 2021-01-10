package com.example.ShopeeSpring.repository;

import com.example.ShopeeSpring.entity.Product;
import com.example.ShopeeSpring.helper.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Product findById(String productId) {
        try {
            String sql = "select * from Product where productID = ?;";
            Object[] params = {productId};
            Product product = (Product) jdbcTemplate.queryForObject(sql, new ProductMapper(), params);
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Product> getAll() {
        try {
            String sql = "select * from Product ;";
            List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
            return listProduct;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
