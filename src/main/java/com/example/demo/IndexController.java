package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "landing/index";
    }

    @GetMapping("/app")
    public String app() {
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

    @GetMapping("/b2c")
    public String b2c() {
        return "landing/b2c";
    }

    @GetMapping("/b2b")
    public String b2b() {
        return "landing/b2b";
    }

    @GetMapping("/company")
    public String company() {
        return "landing/company";
    }

}
