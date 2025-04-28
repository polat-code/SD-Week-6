package org.softwaredev.sdweek6.product.application;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.category.application.CategoryService;
import org.softwaredev.sdweek6.category.domain.entity.Category;
import org.softwaredev.sdweek6.product.domain.entity.Product;
import org.softwaredev.sdweek6.product.domain.http.request.ProductRequest;
import org.softwaredev.sdweek6.product.exceptions.CategoryNotFoundException;
import org.softwaredev.sdweek6.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final CategoryService categoryService;
  private final ProductRepository productRepository;

  public ResponseEntity<Product> createProduct(ProductRequest productRequest)
      throws CategoryNotFoundException {

    Product product = createProductFromProductRequest(productRequest);

    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  private Product createProductFromProductRequest(ProductRequest productRequest)
      throws CategoryNotFoundException {
    Category category = categoryService.findCategoryById(productRequest.categoryId());

    Product product =
        Product.builder()
            .productName(productRequest.productName())
            .category(category)
            .price(productRequest.price())
            .build();

    return productRepository.save(product);
  }
  public ResponseEntity<List<Product>> createMultipleProduct(List<ProductRequest> productRequests) throws CategoryNotFoundException {

    List<Product> products = productRequests.stream().map(this::createProductFromProductRequest).collect(Collectors.toList());

    return new ResponseEntity<>(products, HttpStatus.OK);
  }
}
