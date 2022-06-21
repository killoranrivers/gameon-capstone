package com.killoranrivers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/gamedetails")
public class GameDetailsController {
    @GetMapping
    public String viewDetails() {
        return "gamedetails";
    }

    @GetMapping("{gameId}")
    public String getSpecificGame(@PathVariable("gameId") Long gameId) {
        return "gamedetails";
    }
}
