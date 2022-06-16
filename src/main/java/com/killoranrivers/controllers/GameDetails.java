package com.killoranrivers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameDetails {
    @GetMapping("/gamedetails")
    public String viewDetails() {
        return "gamedetails";
    }
}
