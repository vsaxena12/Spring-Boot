package com.spring_boot.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("DateTime", java.time.LocalTime.now());
        return "helloworld";
    }
}
