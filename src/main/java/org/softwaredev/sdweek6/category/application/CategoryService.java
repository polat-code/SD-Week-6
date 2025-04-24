package org.softwaredev.sdweek6.category.application;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.category.domain.entity.Category;
import org.softwaredev.sdweek6.category.domain.http.request.CreateCategoryRequest;
import org.softwaredev.sdweek6.category.repository.CategoryRepository;
import org.softwaredev.sdweek6.product.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public ResponseEntity<Category> createCategory(CreateCategoryRequest categoryRequest) {
    Category category =
        Category.builder()
            .categoryName(categoryRequest.categoryName())
            .description(categoryRequest.categoryDescription())
            .build();

    category = categoryRepository.save(category);

    return new ResponseEntity<>(category, HttpStatus.OK);
  }

  public Category findCategoryById(Long aLong) throws CategoryNotFoundException {
    Optional<Category> optionalCategory = categoryRepository.findById(aLong);
    if (optionalCategory.isEmpty()) {
      throw new CategoryNotFoundException("There is no such a category");
    }
    return optionalCategory.get();
  }
}
