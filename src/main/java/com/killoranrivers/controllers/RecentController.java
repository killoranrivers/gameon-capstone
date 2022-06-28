package com.killoranrivers.controllers;

import com.killoranrivers.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recent")
public class RecentController {
    private final CommentService commentService;

    @Autowired
    public RecentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public String viewRecent(Model model) {
        model.addAttribute("newComments", commentService.getNewComments());
        return "recent";
    }
}
