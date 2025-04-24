package org.softwaredev.sdweek6.product.interfaces.http;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.product.application.ProductService;
import org.softwaredev.sdweek6.product.domain.entity.Product;
import org.softwaredev.sdweek6.product.domain.http.request.ProductRequest;
import org.softwaredev.sdweek6.product.exceptions.CategoryNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

  private final ProductService productService;

  @PostMapping("")
  public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) throws CategoryNotFoundException {
    return productService.createProduct(productRequest);
  }
}
