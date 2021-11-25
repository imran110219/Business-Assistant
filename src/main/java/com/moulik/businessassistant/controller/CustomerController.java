package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.CustomerService;
import com.moulik.businessassistant.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomer(Model model) {
        List<Customer> list = customerService.getAllCustomers();
        model.addAttribute("customers", list);
        return "customer";
    }
}
