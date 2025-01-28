package com.gerardo.backend.backend.repositories;

import com.gerardo.backend.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
