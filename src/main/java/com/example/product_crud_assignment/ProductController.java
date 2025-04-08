package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  // Use @Autowired to inject the ProductService via constructor
  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // Create
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productService.createProduct(product);
  }

  // Read all
  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  // Read by ID
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable String id) {
    return productService.getProductById(id);
  }

  // Update
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
    return productService.updateProduct(id, updatedProduct);
  }

  // Delete
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
  }
}