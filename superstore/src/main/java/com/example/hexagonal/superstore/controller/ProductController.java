package com.example.hexagonal.superstore.controller;

import com.example.hexagonal.superstore.exception.ResourceNotFoundException;
import com.example.hexagonal.superstore.model.Product;
import com.example.hexagonal.superstore.service.ProductService;

import org.springframework.http.HttpStatus;
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

import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
      this.productService = productService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.findAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Product> getProductById (@PathVariable("id") Long id) throws ResourceNotFoundException {
    Product product = productService.findProductById(id);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product newProduct = productService.addProduct(product);
      return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Product> updateEmployee(@RequestBody Product product) {
    Product updateProduct = productService.updateProduct(product);
    return new ResponseEntity<>(updateProduct, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
    productService.deleteProduct(id);
      return new ResponseEntity<>(HttpStatus.OK);
  }
}
