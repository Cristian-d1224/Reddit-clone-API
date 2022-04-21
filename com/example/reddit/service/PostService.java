package com.example.reddit.service;

import com.example.reddit.dto.PostRequest;
import com.example.reddit.model.Post;
import com.example.reddit.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post save(PostRequest postRequest){
        Post savedPost = postRepository.save(mapToPost(postRequest));
        return savedPost;
    }

    public Post mapToPost(PostRequest postRequest){
        return Post.builder().postId(postRequest.getPostId())
                .postName(postRequest.getPostName())
                .Url(postRequest.getUrl())
                .description(postRequest.getDescription())
                .build();
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post findById(Long id){
        return this.postRepository.findById(id).get();
    }

}
