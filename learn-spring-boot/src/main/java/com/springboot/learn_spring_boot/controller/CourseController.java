package com.springboot.learn_spring_boot.controller;

import com.springboot.learn_spring_boot.model.Courses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Courses> getAllController() {
        return Arrays.asList(new Courses(1, "Learn AWS", ""),
                new Courses(2, "Learn SpringBoot", "Test"));
    }
}
