package com.example.product_crud_assignment;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private List<Product> products = new ArrayList<>();

  // Helper method to find the index of a product by ID
  private int getProductIndex(String id) {
    for (Product product : products) {
      if (product.getId().equals(id)) {
        return products.indexOf(product);
      }
    }
    return -1;
  }

  // Create: Add a new product
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    products.add(product);
    return product;
  }

  // Read: Get all products
  @GetMapping
  public List<Product> getAllProducts() {
    return products;
  }

  // Read: Get a product by ID
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable String id) {
    int index = getProductIndex(id);
    if (index != -1) {
      return products.get(index);
    }
    return null;
  }

  // Update: Update a product by ID
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
    int index = getProductIndex(id);
    if (index != -1) {
      products.set(index, updatedProduct);
      return updatedProduct;
    }
    return null;
  }

  // Delete: Delete a product by ID
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
    int index = getProductIndex(id);
    if (index != -1) {
      products.remove(index);
    }
  }
}
