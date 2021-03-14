package com.example.ShopeeSpring.controller;

import com.example.ShopeeSpring.dto.GetAllProductDto;
import com.example.ShopeeSpring.entity.Account;
import com.example.ShopeeSpring.entity.Product;
import com.example.ShopeeSpring.entity.Session;
import com.example.ShopeeSpring.exception.ApiException;
import com.example.ShopeeSpring.helper.responseBuilder.ResponseForm;
import com.example.ShopeeSpring.repository.AccountRepository;
import com.example.ShopeeSpring.service.AccountService;
import com.example.ShopeeSpring.service.ProductService;
import com.example.ShopeeSpring.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    SessionService sessionService;

    @Autowired
    AccountService accountService;

    @GetMapping("/find-by-id")
    public Product getById(@RequestParam String productID) {
        Product product = productService.findById(productID);
        return product;
    }

    @GetMapping("/get-all-product")
    public List<Product> getAll(@RequestParam(required = false) String sortColumn, @RequestParam(required = false) String sortType) {
        List<Product> listProduct = productService.getAll(sortColumn, sortType);
        return listProduct;
    }

    @PutMapping("/update-by-id")
    public Integer updateById(@RequestBody Product product) {
        return productService.updateById(product);
    }

    @DeleteMapping("/delete-by-id")
    public Integer deleteById(@RequestParam String productID) {
        return productService.deleteById(productID);
    }

    @PostMapping("/add-product")
    public Integer addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public GetAllProductDto getAll(@RequestParam(required = false) String sortColumn, @RequestParam(required = false) String sortType, @RequestHeader(required = false) String token) throws ApiException {
        // query check db lay user tuong ung voi token
        // neu ko co user nao => fail
        // neu co => lay ra user_id
        Session session = sessionService.getSessionByToken(token);
        if (session == null) {
            throw new ApiException("token khong hop le");
        }
        String userId = session.getUserId();
        Account account = accountService.getAccountById(userId);
        List<Product> products;
        // lay duoc user_info
        // lay product_info
        // >> can tao bang: session(user_id, token)
        products = productService.getAll(sortColumn, sortType);
        return new GetAllProductDto(products, account);
    }
}
