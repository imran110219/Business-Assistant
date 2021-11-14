package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();

    Purchase getPurchaseById(Long id) throws RecordNotFoundException;

    Purchase createPurchase(Purchase purchase);

    Purchase updatePurchase(Purchase newPurchase, Long id);

    void deletePurchaseById(Long id);
}
