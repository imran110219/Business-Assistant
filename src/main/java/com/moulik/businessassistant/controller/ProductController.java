package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.ProductService;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getProduct(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "product";
    }
}
