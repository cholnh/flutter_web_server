package com.example.demo.controller._bases;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/privacy")
    public String privacy() {
        return "common/privacy";
    }

    @GetMapping("/terms")
    public String terms() {
        return "common/terms";
    }

    @GetMapping("/refund")
    public String refund() {
        return "common/refund";
    }
}
