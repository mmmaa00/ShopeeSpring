package com.example.ShopeeSpring.repository;

import com.example.ShopeeSpring.entity.Product;
import com.example.ShopeeSpring.helper.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Product findById(String productId) {
        String sql = "select * from Product where deleted = 0 and productID = ?;";
        Object[] params = {productId};
        Product product = (Product) jdbcTemplate.queryForObject(sql, new ProductMapper(), params);
        return product;
    }

    public List<Product> getAll_DESC(String sortColumn) {
        String sql = "select * from Product where deleted = 0 order by " + sortColumn + " desc ;";
        List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
        return listProduct;
    }

    public List<Product> getAll_ASC(String sortColumn) {
        String sql = "select * from Product where deleted = 0 order by " + sortColumn + " asc ;";
        List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
        return listProduct;
    }

    public List<Product> getAll() {
        String sql = "select * from Product where deleted = 0 ;";
        List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
        return listProduct;
    }

    public Integer updateById(Product product) {
        String sql = "UPDATE Product SET " +
                " display =?," +
                " priceIn =?," +
                " priceOut =?," +
                " priceSale =?," +
                " amount =?," +
                " shipday =?," +
                " description =?," +
                " images =? " +
                " WHERE productID =? and deleted = 0;";
        Object params[] = new Object[9];
        params[0] = product.getDisplay();
        params[1] = product.getPriceIn();
        params[2] = product.getPriceOut();
        params[3] = product.getPriceSale();
        params[4] = product.getAmount();
        params[5] = product.getShipday();
        params[6] = product.getDescription();
        params[7] = product.getImages();
        params[8] = product.getProductID();
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteById(String productId) {
        String sql = "UPDATE Product SET deleted = 1 WHERE productID =?;";
        Object[] params = {productId};
        return jdbcTemplate.update(sql, params);
    }

    public Integer addProduct(Product product) {
        String sql = "INSERT INTO Product (productID,display,priceIn,priceOut,priceSale,amount,shipday,description,images) VALUES (?,?,?,?,?,?,?,?,?) ;";
        Object params[] = new Object[9];
        params[0] = UUID.randomUUID().toString();
        params[1] = product.getDisplay();
        params[2] = product.getPriceIn();
        params[3] = product.getPriceOut();
        params[4] = product.getPriceSale();
        params[5] = product.getAmount();
        params[6] = product.getShipday();
        params[7] = product.getDescription();
        params[8] = product.getImages();
        return jdbcTemplate.update(sql, params);
    }
}
