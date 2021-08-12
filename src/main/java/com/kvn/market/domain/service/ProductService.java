package com.kvn.market.domain.service;

import com.kvn.market.domain.Product;
import com.kvn.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return this.productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return this.productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return this.productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return this.productRepository.save(product);
    }

    //if product exists and it can be deleted return true else false
    public boolean delete(int productId){
        if(this.getProduct(productId).isPresent()){
            this.productRepository.delete(productId);
            return true;
        }
        return false;
    }

}
