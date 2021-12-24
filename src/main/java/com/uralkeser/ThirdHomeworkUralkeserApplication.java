package com.uralkeser;

import com.uralkeser.entity.Category;
import com.uralkeser.entity.Product;
import com.uralkeser.entity.ProductReview;
import com.uralkeser.entity.User;
import com.uralkeser.repository.CategoryRepository;
import com.uralkeser.repository.ProductRepository;
import com.uralkeser.repository.ProductReviewRepository;
import com.uralkeser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.math.BigDecimal.TEN;

@SpringBootApplication
public class ThirdHomeworkUralkeserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdHomeworkUralkeserApplication.class, args);

    }

}
