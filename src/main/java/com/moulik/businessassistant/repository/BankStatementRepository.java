package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.BankStatement;
import com.moulik.businessassistant.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {
}
