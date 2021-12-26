package com.uralkeser.service;

import com.uralkeser.entity.Product;
import com.uralkeser.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(String id){

        Optional<Product> optional = ProductRepository.findById(id);

        Product Product = null;
        if (optional.isPresent()){
            Product = optional.get();
        }

        return Product;
    }

    public void deleteById(String id){
        ProductRepository.deleteById(id);
    }

    public Product save(Product Product){
        return ProductRepository.save(Product);
    }
}
