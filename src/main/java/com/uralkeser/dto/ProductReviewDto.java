package com.uralkeser.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.data.annotation.Id;

@JsonFilter("ProductReviewDtoFilter")
public class ProductReviewDto {
    @Id
    private String id;
    private String review;
    private String date;
    private String productId;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ProductReviewDto(String id, String review, String date, String productId, String userId) {
        this.id = id;
        this.review = review;
        this.date = date;
        this.productId = productId;
        this.userId = userId;
    }
}
