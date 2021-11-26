package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.ExpenseService;
import com.moulik.businessassistant.model.Expense;
import com.moulik.businessassistant.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public double getTotalExpenseAmount() {
        return expenseRepository.getTotalExpenseAmount();
    }

    @Override
    public Expense getExpenseById(Long id) throws RecordNotFoundException {
        return expenseRepository.getById(id);
    }

    @Override
    public Expense createExpense(Expense Expense) {
        return expenseRepository.save(Expense);
    }

    @Override
    public Expense updateExpense(Expense newExpense, Long id) {
        return expenseRepository.findById(id)
                .map(expense -> {
                    expense.setUser(newExpense.getUser());
                    expense.setPurpose(newExpense.getPurpose());
                    expense.setAmount(newExpense.getAmount());
                    expense.setDatetime(newExpense.getDatetime());
                    return expenseRepository.save(expense);
                })
                .orElseGet(() -> {
                    newExpense.setId(id);
                    return expenseRepository.save(newExpense);
                });
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }
}
