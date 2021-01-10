package com.example.ShopeeSpring.controller;

import com.example.ShopeeSpring.entity.Product;
import com.example.ShopeeSpring.helper.responseBuilder.ResponseForm;
import com.example.ShopeeSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/find-by-id")
    public ResponseEntity<ResponseForm<Product>> getById(@RequestParam String productId) {
        Product product = productService.findById(productId);
        return ResponseEntity.ok(ResponseForm.responseOk(product,1,"Success"));
    }

    @GetMapping("/get-all-product")
    public ResponseEntity<ResponseForm<List<Product>>> getAll() {
        List<Product> listProduct = productService.getAll();
        return ResponseEntity.ok(ResponseForm.responseOk(listProduct,1,"Success"));
    }
}
