package com.books.springbootbookseller.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = false, length = 1000)
  private String description;

  @Column(name = "author", nullable = false)
  private String author;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @Column(name = "create_date", nullable = false)
  private LocalDateTime createDate;
}
