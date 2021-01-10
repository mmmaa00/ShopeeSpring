package com.example.ShopeeSpring.helper.mapper;

import com.example.ShopeeSpring.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet,int i) throws SQLException {
        Product product = new Product(); //temp;
        product.setProductId(resultSet.getString("productId"));
        product.setDisplay(resultSet.getString("display"));
        product.setDescription(resultSet.getString("description"));
        product.setAmount(resultSet.getInt("amount"));
        product.setShipDay(resultSet.getInt("shipDay"));
        product.setPriceOut(resultSet.getDouble("priceOut"));
        product.setPriceIn(resultSet.getDouble("priceIn"));
        product.setPriceSale(resultSet.getDouble("priceSale"));
        product.setImageUrl(resultSet.getString("imageUrl"));
        return product;
    }
}