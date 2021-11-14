package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id) throws RecordNotFoundException;

    Expense createExpense(Expense expense);

    Expense updateExpense(Expense newExpense, Long id);

    void deleteExpenseById(Long id);
}
