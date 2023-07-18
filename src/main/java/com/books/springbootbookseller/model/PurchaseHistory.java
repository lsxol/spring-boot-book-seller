package com.books.springbootbookseller.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "book_id", nullable = false)
  private Long bookId;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @Column(name = "purchase_time", nullable = false)
  private LocalDateTime purchaseTime;
}
