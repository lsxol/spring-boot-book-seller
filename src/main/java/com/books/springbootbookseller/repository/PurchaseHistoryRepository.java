package com.books.springbootbookseller.repository;

import com.books.springbootbookseller.model.PurchaseHistory;
import com.books.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
  @Query(
      "select b.title as tittle, ph.price as price, ph.purchaseTime as purchaseTime from PurchaseHistory ph left join " +
              "Book b on b.id = ph.bookId where ph.userId = :userId")
  List<IPurchaseItem> findAllPurchaseOfUser(@Param("userId") Long userId);
}
