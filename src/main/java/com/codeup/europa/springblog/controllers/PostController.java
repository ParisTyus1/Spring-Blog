package com.codeup.europa.springblog.controllers;

import com.codeup.europa.springblog.controllers.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String getPosts() {
        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post(2,"title","second post"));
        postList.add(new Post(3,"Title","second post"));
    return "post/index";
    }

    @GetMapping(path = "/posts/{id}")

    public String getPost(@PathVariable int id, Model model) {
        Post post1 = new Post(id, "First Blog", "Help ,me get to hollywood!");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
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


    @RequestMapping(path = "/posts", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(){
        return "DELETE!!";
    }


    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/show")
    @ResponseBody
    public String show() {
        return "show";
    }

    @GetMapping("/join")
    @ResponseBody
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    @ResponseBody
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}
