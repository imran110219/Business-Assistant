package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.iservice.TagService;
import com.moulik.businessassistant.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags")
    public String getAllTags(Model model) {
        List<Tag> list = tagService.getAllTags();
        model.addAttribute("tags", list);
        return "tag";
    }
}
