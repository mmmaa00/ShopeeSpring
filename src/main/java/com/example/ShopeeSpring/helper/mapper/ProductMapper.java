package com.example.ShopeeSpring.helper.mapper;

import com.example.ShopeeSpring.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet,int i) throws SQLException {
        Product product = new Product(); //temp;
        product.setProductID(resultSet.getString("productID"));
        product.setDisplay(resultSet.getString("display"));
        product.setPriceIn(resultSet.getInt("priceIn"));
        product.setPriceOut(resultSet.getInt("priceOut"));
        product.setPriceSale(resultSet.getInt("priceSale"));
        product.setAmount(resultSet.getInt("amount"));
        product.setShipday(resultSet.getInt("shipday"));
        product.setDescription(resultSet.getString("description"));
        product.setImages(resultSet.getString("images"));
        product.setDeleted(resultSet.getInt("deleted"));
        product.setCreate_at(resultSet.getString("create_at"));
        product.setUpdate_at(resultSet.getString("update_at"));
        return product;
    }
}