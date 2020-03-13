package com.codeup.europa.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String getPosts() {
    return "post index page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable int id) {
    return "View and individuals post, id="+ id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm() {
    return "View the form creating the post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
    return "Create new post";
    }
}
