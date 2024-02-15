package com.delo.marketplace.service;

import com.delo.marketplace.model.Product;
import com.delo.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();

    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);

    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    public void update(Product product) {
        productRepository.save(product);
    }
}
