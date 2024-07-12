package com.example.GoogleProject.service;

import com.example.GoogleProject.entity.Post;
import com.example.GoogleProject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post add(Post post){
        postRepository.save(post);
        return post;
    }

    public Post findPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post updatePost(Long id, String body,String title){
        Post post=findPostById(id);
        post.setBody(body);
        post.setTitle(title);

        postRepository.save(post);
        return post;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll(Sort.by("createdAt"));
    }
}
