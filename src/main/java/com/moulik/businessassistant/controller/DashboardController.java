package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.*;
import com.moulik.businessassistant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DashboardController {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final ProductService productService;

    @GetMapping(value="/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("totalIncomeAmount", (int) incomeService.getTotalIncomeAmount());
        modelAndView.addObject("totalExpenseAmount", (int) expenseService.getTotalExpenseAmount());
        modelAndView.addObject("totalProductNumber", productService.getAllProducts().size());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
