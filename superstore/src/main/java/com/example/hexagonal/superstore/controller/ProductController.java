package com.example.hexagonal.superstore.controller;

import com.example.hexagonal.superstore.exception.ResourceNotFoundException;
import com.example.hexagonal.superstore.model.Product;
import com.example.hexagonal.superstore.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/product/{id}")
  public ResponseEntity < Product > getProductById(@PathVariable(value = "id") Long productId)
    throws ResourceNotFoundException {
    Product product = productRepository.findById(productId)
      .orElseThrow(() -> new ResourceNotFoundException("Product not found :: " + productId));
    return ResponseEntity.ok().body(product);
  }

  @PostMapping("/create/product")
  public Product createRoom(@Valid @RequestBody Product product) {
    return productRepository.save(product);
  }

  @PutMapping("/product/{id}")
  public ResponseEntity < Product > updateRoom(@PathVariable(value = "id") Long productId,
                                                    @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
    Product product = productRepository.findById(productId)
      .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));

    product.setDescription(productDetails.getDescription());
    product.setPrice(productDetails.getPrice());
    product.setPurchase(productDetails.getPurchase());
    product.setCategory(productDetails.getCategory());
    product.setQuantity(productDetails.getQuantity());

    final Product updateProduct = productRepository.save(product);
    return ResponseEntity.ok(updateProduct);
  }

  @DeleteMapping("/product/{id}")
  public Map < String, Boolean > deleteProduct(@PathVariable(value = "id") Long productId)
    throws ResourceNotFoundException {
    Product product = productRepository.findById(productId)
      .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

    productRepository.delete(product);
    Map< String, Boolean > response = new HashMap< >();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
