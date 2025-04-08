package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(String id) {
    return productRepository.findById(id);
  }

  public Product updateProduct(String id, Product updatedProduct) {
    return productRepository.update(id, updatedProduct);
  }

  public void deleteProduct(String id) {
    productRepository.delete(id);
  }
}
