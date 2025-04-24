package org.softwaredev.sdweek6.category.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
@Builder
@ToString(of = {"id"})
@EqualsAndHashCode(
    of = {"id"},
    callSuper = false)
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String categoryName;

  private String description;
}
