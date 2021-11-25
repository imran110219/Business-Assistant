package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.TypeService;
import com.moulik.businessassistant.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TypeController {

    private final TypeService typeService;

    @GetMapping("/types")
    public String getAllTypes(Model model) {
        List<Type> list = typeService.getAllTypes();
        model.addAttribute("types", list);
        return "type";
    }
}
