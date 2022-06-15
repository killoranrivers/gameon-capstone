package com.killoranrivers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopRatedController {
    @GetMapping("/toprated")
    public String viewTopRated() {
        return "toprated";
    }
}
