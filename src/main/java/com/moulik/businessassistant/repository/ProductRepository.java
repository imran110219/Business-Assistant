package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Expense, Long> {
}
