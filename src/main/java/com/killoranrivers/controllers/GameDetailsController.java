package com.killoranrivers.controllers;

import com.killoranrivers.models.Comment;
import com.killoranrivers.models.Game;
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

    @PostMapping("/gamedetails/{gameId}/comment") // This will only run if user submits the Thymeleaf form with method="post" th:action="@{/gamedetails/{gameId}/comment}"
    public String addComment(@PathVariable Integer gameId, Model model, @ModelAttribute Comment newComment) {
        Game game = new Game(gameId);
        commentService.addGameComment(gameId, newComment, game);
        return "redirect:/gamedetails/{gameId}";
    }
    
    @GetMapping("/gamedetails/{gameId}")
    public String getSpecificGame(@PathVariable Integer gameId, Model model) {
        model.addAttribute("gameId", gameId);
        model.addAttribute("comments", commentService.getGameComments(gameId));
        model.addAttribute("newComment", new Comment());
        return "gamedetails";
    }
}
