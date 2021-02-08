package com.example.demo.controller.index;

import com.example.demo.service.carte.CarteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class IndexController {

    CarteService carteService;

    @GetMapping
    public String index(
        Model model
    ) {
        model.addAttribute("cartes", carteService.getAll());
        return "landing/index";
    }
}
