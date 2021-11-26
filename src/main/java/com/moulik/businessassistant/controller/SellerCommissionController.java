package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.SellerCommissionService;
import com.moulik.businessassistant.model.SellerCommission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SellerCommissionController {

    private final SellerCommissionService sellerCommissionService;

    @GetMapping("/sellercommissions")
    public String getAllSellerCommissions(Model model) {
        List<SellerCommission> list = sellerCommissionService.getAllSellerCommissions();
        model.addAttribute("sellerCommissions", list);
        return "seller-commission";
    }
}
