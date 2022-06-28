package com.killoranrivers.controllers;

import com.killoranrivers.models.Comment;
import com.killoranrivers.services.CommentService;
import com.killoranrivers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class ProfileController {
    private final CommentService commentService;

    private final UserService userService;

    @Autowired
    public ProfileController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfile(Principal principal, Model model) {
        String email = principal.getName();
        Integer userId = userService.findByEmail(email).getId();
        model.addAttribute("comments", commentService.getUserComments(userId));
        System.out.println();
        return "profile";
    }

    @GetMapping("/profile/deleteComment/{id}")
    public String deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return "redirect:/profile";
    }


}
