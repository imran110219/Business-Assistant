package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT sum(amount) FROM Expense")
    double getTotalExpenseAmount();
}
