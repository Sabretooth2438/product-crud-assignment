package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
  }

  @Override
  public Product updateProduct(Long id, Product updatedProduct) {
    Product existingProduct = getProductById(id);
    existingProduct.setName(updatedProduct.getName());
    existingProduct.setPrice(updatedProduct.getPrice());
    existingProduct.setQuantity(updatedProduct.getQuantity());
    return productRepository.save(existingProduct);
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
