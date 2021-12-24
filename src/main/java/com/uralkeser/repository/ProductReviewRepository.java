package com.uralkeser.repository;

import com.uralkeser.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductReviewRepository extends MongoRepository<ProductReview,String> {

    List<ProductReview> findAllById();

}
