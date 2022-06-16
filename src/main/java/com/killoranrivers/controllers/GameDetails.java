package com.killoranrivers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gamedetails")
public class GameDetails {
    @GetMapping
    public String viewDetails() {
        return "gamedetails";
    }
}
