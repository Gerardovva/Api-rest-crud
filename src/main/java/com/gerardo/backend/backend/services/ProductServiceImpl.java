package com.gerardo.backend.backend.services;

import com.gerardo.backend.backend.entities.Product;
import com.gerardo.backend.backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delateByd(Long id) {
        Optional<Product> productOptional=repository.findById(id);
        if(productOptional.isPresent()){
            repository.deleteById(id);
            return productOptional;
        }
        return Optional.empty();
    }
}
