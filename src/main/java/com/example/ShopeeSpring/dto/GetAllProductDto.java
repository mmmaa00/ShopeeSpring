package com.example.ShopeeSpring.dto;

import com.example.ShopeeSpring.entity.Account;
import com.example.ShopeeSpring.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductDto {
    List<Product> products;
    Account account;

    public GetAllProductDto(List<Product> products, Account account) {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
