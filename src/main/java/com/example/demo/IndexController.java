package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "client/index";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "common/privacy";
    }

    @GetMapping("/terms")
    public String terms() {
        return "common/terms";
    }

    @GetMapping("/store")
    public String store() {
        return "store/index";
    }
}
