package com.books.springbootbookseller.service;

import com.books.springbootbookseller.model.PurchaseHistory;
import com.books.springbootbookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchaseItemsOfUser(Long userId);
}
