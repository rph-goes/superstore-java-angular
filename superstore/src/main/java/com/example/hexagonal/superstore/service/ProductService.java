package com.example.hexagonal.superstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hexagonal.superstore.exception.ResourceNotFoundException;
import com.example.hexagonal.superstore.model.Product;
import com.example.hexagonal.superstore.repository.ProductRepository;
import java.util.List;

@Service
@Transactional
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> findAllProducts() {
      return productRepository.findAll();
  }

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public Product findProductById(Long id) throws ResourceNotFoundException {
    return productRepository.findProductById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
  }

  public void deleteProduct(Long id){
    productRepository.deleteProductById(id);
  }

}
