package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Expense;
import com.moulik.businessassistant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
