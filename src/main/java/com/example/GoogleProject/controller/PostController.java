package com.example.GoogleProject.controller;

import com.example.GoogleProject.service.BotService;
import org.springframework.ui.Model;
import com.example.GoogleProject.entity.Post;
import com.example.GoogleProject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final BotService botService;


    @GetMapping("/publish")
    public String publishPage() {
        return "publish";
    }

    @PostMapping("/publish")
    public String publishPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        int id=botService.sendMessage(post);
        post.setId((long) id);
        postService.add(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        List<Post> posts=postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/post/{id}")
    public String singlePost(@PathVariable Long id, Model model) {
        Post post=postService.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, @RequestParam String title, @RequestParam String body) {
        Post post=postService.updatePost(id, body, title);
        botService.editMessage(id, post);
        return "redirect:/posts";
    }
}
