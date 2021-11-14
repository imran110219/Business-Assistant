package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Expense;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
