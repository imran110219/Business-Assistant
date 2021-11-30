package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.*;
import com.moulik.businessassistant.model.User;
import com.moulik.businessassistant.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class DashboardController {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final ProductService productService;
    private final UserService userService;
    private final InvestmentService investmentService;
    private final WorkingHourService workingHourService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final DataUtil dataUtil;

    @GetMapping(value="/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("totalIncomeAmount", (int) incomeService.getTotalIncomeAmount());
        modelAndView.addObject("totalExpenseAmount", (int) expenseService.getTotalExpenseAmount());
        modelAndView.addObject("totalProductNumber", productService.getAllProducts().size());
        modelAndView.addObject("totalCustomerNumber", customerService.getAllCustomers().size());

        modelAndView.addObject("workerList", workingHourService.getWorkerList());
        modelAndView.addObject("workHourList", workingHourService.getWorkHourList());
        modelAndView.addObject("workHourColorList", dataUtil.getColorListByNumber(workingHourService.getWorkerList().size()));

        modelAndView.addObject("investorList", investmentService.getInvestorList());
        modelAndView.addObject("investList", investmentService.getInvestList());
        modelAndView.addObject("investColorList", dataUtil.getColorListByNumber(investmentService.getInvestList().size()));

        modelAndView.addObject("highestSales", saleService.getHighestSale());
        modelAndView.addObject("lowestSales", saleService.getLowestSale());

        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
