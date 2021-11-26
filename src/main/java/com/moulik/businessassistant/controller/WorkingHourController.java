package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.WorkingHourService;
import com.moulik.businessassistant.model.WorkingHour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class WorkingHourController {

    private final WorkingHourService workingHourService;

    @GetMapping("/workinghours")
    public String getAllWorkingHours(Model model) {
        List<WorkingHour> list = workingHourService.getAllWorkingHours();
        model.addAttribute("workingHours", list);
        return "working-hour";
    }
}
