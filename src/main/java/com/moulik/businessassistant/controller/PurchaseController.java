package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.PurchaseService;
import com.moulik.businessassistant.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping("/purchases")
    public String getPurchases(Model model) {
        List<Purchase> list = purchaseService.getAllPurchases();
        model.addAttribute("purchases", list);
        return "purchase";
    }
}
