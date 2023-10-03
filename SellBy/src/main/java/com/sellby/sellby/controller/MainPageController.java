package com.sellby.sellby.controller;

import com.sellby.sellby.services.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainPageController {
    private final MainPageService mainPageService;

    @Autowired
    public MainPageController(MainPageService mainPageService){
        this.mainPageService = mainPageService;
    }

    @GetMapping("/")
    public String MainPage(Model model){
        model.addAttribute("top_row_products", mainPageService.GetTopRowProducts());
        model.addAttribute("bottom_row_products", mainPageService.GetBottomRowProducts());
        return "mainPage";
    }
}
