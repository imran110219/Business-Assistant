package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.RoleService;
import com.moulik.businessassistant.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public String getAllRoles(Model model) {
        List<Role> list = roleService.getAllRoles();
        model.addAttribute("roles", list);
        return "role";
    }
}
