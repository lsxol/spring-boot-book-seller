package com.books.springbootbookseller.service;

import com.books.springbootbookseller.model.PurchaseHistory;
import com.books.springbootbookseller.repository.PurchaseHistoryRepository;
import com.books.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {
  private final PurchaseHistoryRepository purchaseHistoryRepository;

  public PurchaseHistoryService(PurchaseHistoryRepository purchaseHistoryRepository) {
    this.purchaseHistoryRepository = purchaseHistoryRepository;
  }

  @Override
  public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
    purchaseHistory.setPurchaseTime(LocalDateTime.now());
    return purchaseHistoryRepository.save(purchaseHistory);
  }

  @Override
  public List<IPurchaseItem> findPurchaseItemsOfUser(Long userId) {
    return purchaseHistoryRepository.findAllPurchaseOfUser(userId);
  }
}
