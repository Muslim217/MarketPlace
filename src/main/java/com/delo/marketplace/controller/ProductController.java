package com.delo.marketplace.controller;

import com.delo.marketplace.model.Product;
import com.delo.marketplace.service.ProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private Gson gson = new Gson();

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/find-all")
    public String findAll() {
        List<Product> products = productService.findAll();
        return gson.toJson(products);

    }

    @GetMapping("/find-by-id")
    public String findById(@RequestParam String id) {
        Optional<Product> product = productService.findById(Long.valueOf(id));
        return gson.toJson(product.get(), Product.class);
    }

    @PostMapping("/save-product")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>("Данные занесены", HttpStatus.OK);

    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(@RequestParam String id) {
        productService.deleteById(Long.valueOf(id));
        return new ResponseEntity<>("Удаление успешно", HttpStatus.OK);
    }

    @PostMapping("/update-product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>("Изменение успешно", HttpStatus.OK);
    }


}
