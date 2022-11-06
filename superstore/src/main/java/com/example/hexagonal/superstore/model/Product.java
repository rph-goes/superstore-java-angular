package com.example.hexagonal.superstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  private Long id;
  private String description;
  private Float price;
  private String purchase;
  private String category;
  private Integer quantity; 


  public Product(){
  }

  public Product(Long id, String description, Float price, String purchase, String category, Integer quantity){
    this.id = id;
    this.description = description;
    this.price = price;
    this.purchase = purchase;
    this.category = category;
    this.quantity = quantity;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "description", nullable = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "price", nullable = false)
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  @Column(name = "purchase", nullable = false)
  public String getPurchase() {
    return purchase;
  }

  public void setPurchase(String purchase) {
    this.purchase = purchase;
  }

  @Column(name = "category", nullable = false)
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Column(name = "quantity", nullable = false)
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
