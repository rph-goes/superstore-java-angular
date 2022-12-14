package com.example.hexagonal.superstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hexagonal.superstore.model.Product;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
  void deleteProductById(Long id);

  Optional<Product> findProductById(Long id);
}
