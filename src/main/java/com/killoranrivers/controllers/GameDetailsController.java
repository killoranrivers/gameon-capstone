package com.killoranrivers.controllers;

import com.killoranrivers.models.Comment;
import com.killoranrivers.models.Game;
import com.killoranrivers.models.User;
import com.killoranrivers.services.CommentService;
import com.killoranrivers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping
public class GameDetailsController {
    private final CommentService commentService;

    private final UserService userService;

    @Autowired
    public GameDetailsController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/gamedetails/{gameId}/comment")
    // This will only run if user submits the Thymeleaf form with method="post" th:action="@{/gamedetails/{gameId}/comment}"
    public String addComment(@PathVariable Integer gameId, Model model, @ModelAttribute Comment newComment, @RequestParam(value = "title", required = false) String title, Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);
        Game game = new Game(gameId, title);
        commentService.addGameComment(gameId, newComment, user, game);
        return "redirect:/gamedetails/{gameId}";
    }

    @GetMapping("/gamedetails/{gameId}")
    public String getSpecificGame(@PathVariable Integer gameId, Model model, Principal principal) {
        String email = principal.getName();
        String username = userService.findByEmail(email).getUsername();
        model.addAttribute("username", username);
        model.addAttribute("gameId", gameId);
        model.addAttribute("comments", commentService.getGameComments(gameId));
        model.addAttribute("newComment", new Comment());
        return "gamedetails";
    }
}
