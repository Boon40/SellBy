package com.sellby.sellby.controller;


import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.service.ProductPageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductPageController {
    private final ProductPageService productPageService;

    ProductPageController(ProductPageService productPageService){
        this.productPageService = productPageService;
    }

    @GetMapping("/product/{productId}")
    public String GetProduct(@PathVariable int productId, Model model){
        User seller = productPageService.GetProductById(productId).getSeller();
        model.addAttribute("product", productPageService.GetProductById(productId));
        model.addAttribute("sellerRating", productPageService.GetAverageUserRating(seller));
        model.addAttribute("commentsCount", productPageService.GetCommentsCount(seller));
        return "productPage";
    }
}
