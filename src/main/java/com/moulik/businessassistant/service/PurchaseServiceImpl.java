package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.PurchaseService;
import com.moulik.businessassistant.model.Purchase;
import com.moulik.businessassistant.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase getPurchaseById(Long id) throws RecordNotFoundException {
        return purchaseRepository.getById(id);
    }

    @Override
    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Purchase newPurchase, Long id) {
        return purchaseRepository.findById(id)
                .map(purchase -> {
                    purchase.setProduct(newPurchase.getProduct());
                    purchase.setExpense(newPurchase.getExpense());
                    purchase.setQuantity(newPurchase.getQuantity());
                    purchase.setExpiryDatetime(newPurchase.getExpiryDatetime());
                    purchase.setDatetime(newPurchase.getDatetime());
                    purchase.setTotal(newPurchase.getTotal());
                    purchase.setUnit(newPurchase.getUnit());
                    purchase.setUnitPrice(newPurchase.getUnitPrice());
                    return purchaseRepository.save(purchase);
                })
                .orElseGet(() -> {
                    newPurchase.setId(id);
                    return purchaseRepository.save(newPurchase);
                });
    }

    @Override
    public void deletePurchaseById(Long id) {
        purchaseRepository.deleteById(id);
    }
}
