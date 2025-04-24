package org.softwaredev.sdweek6.product.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.softwaredev.sdweek6.category.domain.entity.Category;

@Entity(name = "products")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString(
    callSuper = false,
    of = {"id"})
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String productName;
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

}
