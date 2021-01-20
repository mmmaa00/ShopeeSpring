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

    public List<Product> getAll(String sortColumn,int choice) {
        if(choice == 0) { //desc: giảm dần
            String sql = "select * from Product where deleted = 0 order by " + sortColumn + " desc ;";
            List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
            return listProduct;
        } else if(choice == 1) { //asc: tăng dần
            String sql = "select * from Product where deleted = 0 order by " + sortColumn + " asc ;";
            List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
            return listProduct;
        } else {
            return null;
        }
    }

    public List<Product> getAll() {
        String sql = "select * from Product where deleted = 0;";
        List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());
        return listProduct;

    }

    public Integer updateById(Product product) {
        String sql = "update Product set display =? , priceIn =? , priceOut =?, priceSale =?, amount =?, shipday =?, description =?, images =?, update_at =? where and productID = ?;";
        return jdbcTemplate.update(sql, product.getDisplay(), product.getPriceIn(), product.getPriceOut(), product.getPriceSale(), product.getAmount(), product.getShipday(), product.getDescription(), product.getImages(), product.getUpdate_at(), product.getProductID());
    }

    public  Integer deletedById(String productId) {
        String sql = "update from Product set deleted = 1 where productID = ?;";
        Object[] params = {productId};
        return jdbcTemplate.update(sql, params);
    }

    public Integer addProduct(Product product) {
        String sql = "insert into Product (productID, display, priceIn, priceOut, priceSale, amount, shipday, description, images) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {UUID.randomUUID().toString(), product.getDisplay(), product.getPriceIn(), product.getPriceOut(), product.getPriceSale(), product.getAmount(), product.getShipday(), product.getDescription(), product.getImages()};
        return jdbcTemplate.update(sql, params);
    }
}
