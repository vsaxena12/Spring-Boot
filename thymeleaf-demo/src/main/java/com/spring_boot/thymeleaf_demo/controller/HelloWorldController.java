package com.spring_boot.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //Show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form"; //Connects the view (helloworld-form.html) with the controller
    }

    // Process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld"; //Connects the view (helloworld.html) with the controller
    }

}
