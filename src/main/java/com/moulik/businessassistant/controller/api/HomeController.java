package com.moulik.businessassistant.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Sadman
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
}
