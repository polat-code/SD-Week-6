package org.softwaredev.sdweek6.product.domain.http.request;

import lombok.Builder;

@Builder
public record ProductRequest(String productName, Double price, Long categoryId) {}
