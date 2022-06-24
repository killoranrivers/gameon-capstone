package com.killoranrivers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class GameDetailsController {
    @GetMapping("/gamedetails/{gameId}")
    public String getSpecificGame(@PathVariable("gameId") Long gameId) {
        return "gamedetails";
    }
}
