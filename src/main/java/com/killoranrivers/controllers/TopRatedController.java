package com.killoranrivers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toprated")
public class TopRatedController {
    @GetMapping
    public String viewTopRated() {
        return "toprated";
    }
}
