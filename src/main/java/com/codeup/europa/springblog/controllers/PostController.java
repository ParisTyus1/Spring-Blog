package com.codeup.europa.springblog.controllers;

import com.codeup.europa.springblog.models.Post;
//import com.codeup.europa.springblog.repositories.PostRepository;
import com.codeup.europa.springblog.models.User;
import com.codeup.europa.springblog.repositories.PostRepo;
import com.codeup.europa.springblog.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private PostRepo postDao;
    private UserRepo userDoa;

    public PostController(PostRepo postDao, UserRepo userDoa) {
        this.postDao = postDao;
        this.userDoa = userDoa;
    }


//show it just
    @GetMapping("/posts")
    @ResponseBody
    List<Post>getAllPost(){
        return postDao.findAll();
    }

    @GetMapping("posts/show")
    public String showAllPosts(Model model){
        List<Post>postList = postDao.findAll();
        model.addAttribute("postsList", postList);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePostForm(){
        return "posts/create";
    }

    @GetMapping("/make/user")
    public String blogUser(){
        User newUser = new User();
        newUser.setUsername("Soup Cooler");
        newUser.setEmail("Velvetvoice@something.com");
        newUser.setPassword("Slickback");
        userDoa.save(newUser);
        return "posts/show";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam long id,@RequestParam String title, @RequestParam String body){
        Post postCreate =  new Post();
        User user = userDoa.findUserById(id);
        postCreate.setTitle(title);
        postCreate.setBody(body);
        postCreate.setUser(user);
        postDao.save(postCreate);
        return "redirect:create";

    }


    @GetMapping("/posts/save")
    @ResponseBody
    public String savePost(){
        Post newPost = new Post();
        newPost.setTitle("New Post");
        newPost.setBody("This is a newly saved description");
        postDao.save(newPost);
        return "Saving Post";
    }

    @GetMapping("/posts/update")
    public String updatePostForm() {
        return "posts/update";
    }

    @PostMapping("/posts/update")
    public String updatePost(@RequestParam long id, @RequestParam String title,@RequestParam String body) {
        Post postUpdate = postDao.getOne(id);
        postUpdate.setTitle(title);
        postUpdate.setBody(body);
        postDao.save(postUpdate);
        return "posts/show";
    }

    @DeleteMapping("/posts/delete")
    public String deletePost(@RequestParam long id, Model model){
        Post post = postDao.getOne(id);
        String deletedTitle = post.getTitle();
        String deletedbody = post.getBody();
        model.addAttribute("title", deletedTitle);
        model.addAttribute("body", deletedbody);
        postDao.deleteById(id);
        return "redirect:show";
    }
}
