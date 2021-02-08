package com.example.demo.controller.b2c;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class B2CController {

    @GetMapping("/b2c")
    public String b2C() {
        return "landing/b2c";
    }
}
