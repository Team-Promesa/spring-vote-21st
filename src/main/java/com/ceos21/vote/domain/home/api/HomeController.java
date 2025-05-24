package com.ceos21.vote.domain.home.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "login"; // src/main/resources/templates/login.html
    }
}