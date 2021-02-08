package com.example.demo.controller.order;

import com.example.demo.domain.carte.Carte;
import com.example.demo.service.carte.CarteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequestMapping("/order")
@Controller
@AllArgsConstructor
public class OrderController {

    CarteService carteService;

    @GetMapping
    public String order(
            HttpSession session,
            @RequestParam(value = "pIdx", required = false) Long pIdx,
            @RequestParam(value = "quantity", required = false) Integer quantity
    ) {
        session.setAttribute("pIdx", pIdx);
        session.setAttribute("quantity", quantity);
        return "landing/order/order";
    }

    @GetMapping("/products/{type}")
    public String products(
            Model model,
            @PathVariable(value = "type", required = false) String type
    ) {
        Carte carte = carteService.getToday();
        String productName;
        switch (type) {
            case "basic": productName = "포만세트"; break;
            case "standard": productName = "만족세트"; break;
            case "premium": productName = "감동세트"; break;
            default: return "redirect:/order"; // new RedirectView("/order"); // 오류시 주석으로 시도.
        }
        model.addAttribute("type", type);
        model.addAttribute("productName", productName);
        model.addAttribute("products", carte);
        return "landing/order/product";
    }
}
