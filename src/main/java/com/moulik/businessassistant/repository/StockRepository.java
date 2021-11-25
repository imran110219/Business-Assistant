package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
