package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
