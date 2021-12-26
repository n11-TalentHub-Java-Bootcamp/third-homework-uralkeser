package com.uralkeser.controller;

import com.uralkeser.entity.Product;
import com.uralkeser.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody Product category) {

        category = productService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.deleteById(id);
    }
}
