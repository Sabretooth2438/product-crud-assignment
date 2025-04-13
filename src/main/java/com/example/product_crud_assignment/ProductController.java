package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')") // Restrict to ADMIN only
  public Product createProduct(@RequestBody Product product) {
    return productService.createProduct(product);
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')") // Optional: restrict edit to ADMIN
  public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProduct(id, product);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')") // Optional: restrict delete to ADMIN
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }

  // ✅ DEBUG ENDPOINT
  @GetMapping("/debug-role")
  public String checkRole(Authentication auth) {
    return "Logged in as: " + auth.getName() + ", Roles: " + auth.getAuthorities().toString();
  }
}
