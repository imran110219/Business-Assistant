package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.BankStatementService;
import com.moulik.businessassistant.model.BankStatement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BankStatementController {

    private final BankStatementService bankStatementService;

    @GetMapping("/bankstatements")
    public String getBankStatement(Model model) {
        List<BankStatement> list = bankStatementService.getAllBankStatements();
        model.addAttribute("bankStatements", list);
        return "bank-statement";
    }
}
