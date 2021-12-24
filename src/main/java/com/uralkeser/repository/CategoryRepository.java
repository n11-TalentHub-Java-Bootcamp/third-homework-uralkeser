package com.uralkeser.repository;

import com.uralkeser.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category,String> {

    List<Category> findAllById();

}
