package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.IncomeService;
import com.moulik.businessassistant.model.Income;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping("/incomes")
    public String getIncomes(Model model) {
        List<Income> list = incomeService.getAllIncomes();
        model.addAttribute("incomes", list);
        return "income";
    }
}
