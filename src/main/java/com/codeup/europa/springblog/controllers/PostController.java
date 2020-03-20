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

    @GetMapping("/make/user")
    public String blogUser(@RequestParam long id){
        User newUser = new User();
        newUser.setUsername("Soup Cooler");
        newUser.setEmail("Velvetvoice@something.com");
        newUser.setPassword("Slickback");
        userDoa.save(newUser);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String getCreatePostForm(Model model){
        model.addAttribute("post,", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        Post postCreate =  new Post();
        User user = userDoa.findUserById(id);
        postCreate.setTitle(post.getTitle());
        postCreate.setBody(post.getBody());
        postCreate.setUser(user);
        postDao.save(postCreate);
        return "redirect:show";

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

    @GetMapping("/posts/{id}/update")
    public String updatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/update";
    }

    @PostMapping("/posts/{id}/update")
    public String updatePost(@ModelAttribute Post post, @PathVariable long id) {
        Post postUpdate = postDao.getOne(id);
        postUpdate.setTitle(post.getTitle());
        postUpdate.setBody(post.getBody());
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
