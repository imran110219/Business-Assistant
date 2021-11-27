package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.InvestmentService;
import com.moulik.businessassistant.model.Investment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class InvestmentController {

    private final InvestmentService investmentService;

    @GetMapping("/investments")
    public String getInvestment(Model model) {
        List<Investment> list = investmentService.getAllInvestments();
        model.addAttribute("investments", list);
        return "investment";
    }
}
