package com.killoranrivers.controllers;

import com.killoranrivers.models.Comment;
import com.killoranrivers.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class GameDetailsController {
    private final CommentService commentService;

    @Autowired
    public GameDetailsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentService.getGameComments(2454L);
    }
    
    @GetMapping("/gamedetails/{gameId}")
    public String getSpecificGame(@PathVariable Long gameId) {
        return "gamedetails";
    }
}
