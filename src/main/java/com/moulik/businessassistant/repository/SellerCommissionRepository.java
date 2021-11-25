package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.SellerCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerCommissionRepository extends JpaRepository<SellerCommission, Long> {
}
