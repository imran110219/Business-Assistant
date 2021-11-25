package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.ExpenseService;
import com.moulik.businessassistant.model.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public String getExpenses(Model model) {
        List<Expense> list = expenseService.getAllExpenses();
        model.addAttribute("expenses", list);
        return "expense";
    }
}
