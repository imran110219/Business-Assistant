package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.UnitService;
import com.moulik.businessassistant.model.Unit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UnitController {

    private final UnitService unitService;

    @GetMapping("/units")
    public String getAllUnits(Model model) {
        List<Unit> list = unitService.getAllUnits();
        model.addAttribute("units", list);
        return "unit";
    }
}
