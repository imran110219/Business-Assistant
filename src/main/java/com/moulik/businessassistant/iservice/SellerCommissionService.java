package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.SellerCommission;

import java.util.List;

public interface SellerCommissionService {
    List<SellerCommission> getAllSellerCommissions();

    SellerCommission getSellerCommissionById(Long id) throws RecordNotFoundException;

    SellerCommission createSellerCommission(SellerCommission sellerCommission);

    SellerCommission updateSellerCommission(SellerCommission newSellerCommission, Long id);

    void deleteSellerCommissionById(Long id);
}
