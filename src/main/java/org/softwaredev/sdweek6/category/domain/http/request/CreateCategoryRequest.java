package org.softwaredev.sdweek6.category.domain.http.request;

import lombok.Builder;

@Builder
public record CreateCategoryRequest(String categoryName, String categoryDescription) {}
