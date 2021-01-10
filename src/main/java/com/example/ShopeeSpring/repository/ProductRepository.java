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
            String sql = "select * from product where productId = ?;";
            Object[] params = {productId};
            Product product = (Product) jdbcTemplate.queryForObject(sql, new ProductMapper(), params);
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Product> getAll() {
        try {
            String sql = "select * from product ;";
            List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
            return listProduct;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean createProduct(String productId, String display, String description, int amount, int shipDay, double priceOut, double priceIn, double priceSale, String imageUrl) {
        try {
            String sql = "insert into product(productId, display, description, amount, shipDay, priceOut, priceIn, priceSale, imageUrl) values (?,?,?,?,?,?,?,?,?);";
            jdbcTemplate.update(sql, productId, display, description, amount, shipDay, priceOut, priceIn, priceSale, imageUrl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
