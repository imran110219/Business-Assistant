package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.SellerCommissionService;
import com.moulik.businessassistant.model.SellerCommission;
import com.moulik.businessassistant.repository.SellerCommissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class SellerCommissionServiceImpl implements SellerCommissionService {
    private final SellerCommissionRepository sellerCommissionRepository;

    @Override
    public List<SellerCommission> getAllSellerCommissions() {
        return sellerCommissionRepository.findAll();
    }

    @Override
    public SellerCommission getSellerCommissionById(Long id) throws RecordNotFoundException {
        return sellerCommissionRepository.getById(id);
    }

    @Override
    public SellerCommission createSellerCommission(SellerCommission sellerCommission) {
        return sellerCommissionRepository.save(sellerCommission);
    }

    @Override
    public SellerCommission updateSellerCommission(SellerCommission newSellerCommission, Long id) {
        return sellerCommissionRepository.findById(id)
                .map(sellerCommission -> {
                    sellerCommission.setProduct(newSellerCommission.getProduct());
                    sellerCommission.setAmount(newSellerCommission.getAmount());
                    sellerCommission.setSeller(newSellerCommission.getSeller());
                    sellerCommission.setDatetime(newSellerCommission.getDatetime());
                    return sellerCommissionRepository.save(sellerCommission);
                })
                .orElseGet(() -> {
                    newSellerCommission.setId(id);
                    return sellerCommissionRepository.save(newSellerCommission);
                });
    }

    @Override
    public void deleteSellerCommissionById(Long id) {
        sellerCommissionRepository.deleteById(id);
    }
}
