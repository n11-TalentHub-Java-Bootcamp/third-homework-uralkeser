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
import org.springframework.boot.CommandLineRunner;
import static java.math.BigDecimal.TEN;

@SpringBootApplication
public class CreateDatabaseApplication implements CommandLineRunner{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductReviewRepository productReviewRepository;
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CreateDatabaseApplication.class,args);
    }

    public void run(String... args) throws Exception{
        Category category = new Category("1","First Category",1L,"" );
        Product product = new Product("1","First Product",TEN,"11-11-2021","1");
        User user = new User("1","Ural","Keser","ural@mail.com","05XXXXXXXXX","ural");
        ProductReview productReview = new ProductReview("1","Good","12-11-2021","1","1");

        categoryRepository.save(category);
        productRepository.save(product);
        userRepository.save(user);
        productReviewRepository.save(productReview);


    }

}
