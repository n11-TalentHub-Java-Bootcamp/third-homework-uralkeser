package com.uralkeser.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.uralkeser.converter.ProductReviewConverter;
import com.uralkeser.dto.ProductReviewDto;
import com.uralkeser.entity.ProductReview;
import com.uralkeser.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productsReviews")
public class ProductReviewController {

    @Autowired
    ProductReviewService productReviewService;

    @GetMapping("")
    public MappingJacksonValue findAll() {
        List<ProductReview> productReviewList;
        productReviewList = productReviewService.findAll();
        List<ProductReviewDto> productReviewDtoList = ProductReviewConverter.INSTANCE.convertProductReviewListToProductReviewDtoList(productReviewList);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("review","date");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("ProductReviewDtoFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(productReviewDtoList);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable String id) {
        ProductReview productReview = productReviewService.findById(id);
        ProductReviewDto productReviewDto = ProductReviewConverter.INSTANCE.convertProductReviewToProductReviewDto(productReview);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("review","date");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("ProductReviewDtoFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(productReviewDto);
        mapping.setFilters(filters);
        return mapping;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductReviewDto productReviewDto) {

        ProductReview  productReview = ProductReviewConverter.INSTANCE.convertProductReviewDtoToProductReview(productReviewDto);

        productReview = productReviewService.save(productReview);

        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productReviewService.deleteById(id);
    }
}
