package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.SaleService;
import com.moulik.businessassistant.model.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SaleController {

    private final SaleService saleService;

    @GetMapping("/sales")
    public String getSales(Model model) {
        List<Sale> list = saleService.getAllSales();
        model.addAttribute("sales", list);
        return "sale";
    }
}
