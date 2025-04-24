package org.softwaredev.sdweek6.category.interfaces.http;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.category.application.CategoryService;
import org.softwaredev.sdweek6.category.domain.entity.Category;
import org.softwaredev.sdweek6.category.domain.http.request.CreateCategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @PostMapping("")
  public ResponseEntity<Category> createCategory(
      @RequestBody CreateCategoryRequest categoryRequest) {
    return categoryService.createCategory(categoryRequest);
  }
}
