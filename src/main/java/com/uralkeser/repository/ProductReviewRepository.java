package com.uralkeser.repository;

import com.uralkeser.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview,String> {

    List<ProductReview> findAllById();

}
