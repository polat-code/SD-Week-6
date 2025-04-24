package org.softwaredev.sdweek6.product.application;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.category.application.CategoryService;
import org.softwaredev.sdweek6.category.domain.entity.Category;
import org.softwaredev.sdweek6.product.domain.entity.Product;
import org.softwaredev.sdweek6.product.domain.http.request.ProductRequest;
import org.softwaredev.sdweek6.product.exceptions.CategoryNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final CategoryService categoryService;

  public ResponseEntity<Product> createProduct(ProductRequest productRequest) throws CategoryNotFoundException {

    Category category = categoryService.findCategoryById(productRequest.categoryId());

    Product product = Product.builder()
            .productName(productRequest.productName())
            .price(productRequest.price())
            .build();


    return null;
  }
}
