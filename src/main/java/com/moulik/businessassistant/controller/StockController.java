package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.StockService;
import com.moulik.businessassistant.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks")
    public String getAllStocks(Model model) {
        List<Stock> list = stockService.getAllStocks();
        model.addAttribute("stocks", list);
        return "stock";
    }
}
