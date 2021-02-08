package com.example.demo.controller._bases;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebAppController {
    /**
     * flutter client web app
     */
    @GetMapping("/app")
    public String app() {
        return "client/index";
    }

    /**
     * flutter store web app
     */
    @GetMapping("/store")
    public String store() {
        return "store/index";
    }
}
