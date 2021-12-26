package com.uralkeser.controller;

import com.uralkeser.entity.ProductReview;
import com.uralkeser.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productsReviews")
public class ProductReviewController {

    @Autowired
    ProductReviewService productReviewService;

    @GetMapping("")
    public List<ProductReview> findAll() {
        return productReviewService.findAll();
    }

    @GetMapping("/{id}")
    public ProductReview findById(@PathVariable String id) {
        return productReviewService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductReview category) {

        category = productReviewService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productReviewService.deleteById(id);
    }
}
