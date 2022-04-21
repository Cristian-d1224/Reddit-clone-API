package com.example.reddit.controller;


import com.example.reddit.dto.PostRequest;
import com.example.reddit.model.Post;
import com.example.reddit.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postService.save(postRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }


    @GetMapping("/by-id/{id}")
    public ResponseEntity<Post> getPostsById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.findById(id));
    }

}
