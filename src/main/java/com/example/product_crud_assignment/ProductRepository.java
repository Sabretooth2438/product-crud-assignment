package com.example.product_crud_assignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

  private final List<Product> products = new ArrayList<>();

  public ProductRepository() {
    // Preload some products into the list
    products.add(new Product("1", "Laptop", "Gaming Laptop", 1200.0, 10));
    products.add(new Product("2", "Phone", "Smartphone", 800.0, 15));
  }

  public Product save(Product product) {
    products.add(product);
    return product;
  }

  public List<Product> findAll() {
    return products;
  }

  public Product findById(String id) {
    for (Product product : products) {
      if (product.getId().equals(id)) {
        return product;
      }
    }
    return null;
  }

  public Product update(String id, Product updatedProduct) {
    int index = getProductIndex(id);
    if (index != -1) {
      products.set(index, updatedProduct);
      return updatedProduct;
    }
    return null;
  }

  public void delete(String id) {
    int index = getProductIndex(id);
    if (index != -1) {
      products.remove(index);
    }
  }

  private int getProductIndex(String id) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }
}
