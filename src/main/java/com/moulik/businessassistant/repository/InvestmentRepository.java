package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.BankStatement;
import com.moulik.businessassistant.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    @Query("SELECT sum(amount) FROM Investment group by investor order by investor.userName")
    List<Double> getInvestList();
}
