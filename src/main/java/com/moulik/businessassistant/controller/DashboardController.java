package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        return "dashboard";
    }
}
