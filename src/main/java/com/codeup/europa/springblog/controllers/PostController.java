package com.codeup.europa.springblog.controllers;

import com.codeup.europa.springblog.models.Post;
import com.codeup.europa.springblog.models.User;
import com.codeup.europa.springblog.repositories.PostRepo;
import com.codeup.europa.springblog.repositories.UserRepo;
import com.codeup.europa.springblog.services.MailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private PostRepo postDao;
    private UserRepo userDoa;
    private final MailService mailService;

    public PostController(PostRepo postDao, UserRepo userDoa, MailService mailService ) {
        this.postDao = postDao;
        this.userDoa = userDoa;
        this.mailService = mailService;
    }





    @GetMapping("/posts")
    public String getAllPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//    @GetMapping("posts/show")
//    public String showAllPosts(Model model){
//        List<Post>postList = postDao.findAll();
//        model.addAttribute("postsList", postList);
//        return "posts/show";
//    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model, Principal principal){
        String userName = "";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePostForm(Model model){
        model.addAttribute("post,", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        post.setUser(userDoa.getOne(1l));
        postDao.save(post);
        String emailSubject = "This is an email";
        String emailbody = "This is the body of an email";
//        mailService.prepareAndSend(new Post(), emailSubject, emailbody);
        return "redirect:/posts";

    }
//    @GetMapping("/make/user")
//    public String blogUser(){
//        User newUser = new User();
//        newUser.setUsername("Soup Cooler");
//        newUser.setEmail("Velvetvoice@something.com");
//        newUser.setPassword("Slickback");
//        userDoa.save(newUser);
//        return "posts/show";
//    }

    @GetMapping("/posts/save")
    @ResponseBody
    public String savePost(){
        Post newPost = new Post();
        newPost.setTitle("New Post");
        newPost.setBody("This is a newly saved description");
        postDao.save(newPost);
        return "Saving Post";
    }

    @GetMapping("/posts/{id}/update")
    public String updatePostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", new Post());
        return "posts/update";
    }

    @PostMapping("/posts/{id}/update")
    public String updateForm(@PathVariable long id, @ModelAttribute Post post) {
        Post postUpdate = postDao.getOne(id);
        postUpdate.setTitle(post.getTitle());
        postUpdate.setBody(post.getBody());
        postDao.save(postUpdate);
        return "redirect:/posts/index";
    }

    @DeleteMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
       User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if (loggedinUser.getId() == postDao.getOne(id).getUser().getId())
           postDao.deleteById(id);
        return "redirect:/posts/index";
    }
}
