package com.example.demo.controller.b2b;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class B2BController {

    @GetMapping("/b2b")
    public String b2b() {
        return "landing/b2b";
    }
}
