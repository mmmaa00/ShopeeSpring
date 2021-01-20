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
    public ResponseEntity<ResponseForm<Product>> getById(@RequestParam String productID) {
        Product product = productService.findById(productID);
        return ResponseEntity.ok(ResponseForm.responseOk(product,1,"Success"));
    }

    @GetMapping("/get-all-product/sort")
    public ResponseEntity<ResponseForm<List<Product>>> getAll(@RequestParam String sortColumn,@RequestParam int choice) {
        List<Product> listProduct = productService.getAll(sortColumn, choice);
        return ResponseEntity.ok(ResponseForm.responseOk(listProduct,1,"Success"));
    }

    @GetMapping("/get-all-product")
    public ResponseEntity<ResponseForm<List<Product>>> getAll() {
        List<Product> listProduct = productService.getAll();
        return ResponseEntity.ok(ResponseForm.responseOk(listProduct,1,"Success"));
    }

    @PutMapping("/update-by-id")
    public ResponseEntity<ResponseForm<Integer>> updateById(@RequestBody Product product) {
        int result = productService.updateById(product);
        return ResponseEntity.ok(ResponseForm.responseOk(result, 1, "Success"));
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<ResponseForm<Integer>> deleteById(@RequestParam String productID) {
        int result = productService.deleteById(productID);
        return ResponseEntity.ok(ResponseForm.responseOk(result, 1, "Success"));
    }

    @PostMapping("/add-product")
    public ResponseEntity<ResponseForm<Integer>> addProduct(@RequestBody Product product) {
        int result = productService.addProduct(product);
        return ResponseEntity.ok(ResponseForm.responseOk(result, 1, "Success"));
    }

    @RequestMapping("/test-ex")
    public Integer testException(@RequestParam Integer input) {
        return input;
    }
}
