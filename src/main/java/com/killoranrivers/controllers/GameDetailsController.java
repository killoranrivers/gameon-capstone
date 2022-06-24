package com.killoranrivers.controllers;

import com.killoranrivers.models.Comment;
import com.killoranrivers.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
public class GameDetailsController {
    private final CommentService commentService;

    @Autowired
    public GameDetailsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> getComments() {
        return commentService.getGameComments(2454);
    }
    
    @GetMapping("/gamedetails/{gameId}")
    public String getSpecificGame(@PathVariable Integer gameId, Model model) {
        model.addAttribute("comments", commentService.getGameComments(gameId));
        return "gamedetails";
    }
}
