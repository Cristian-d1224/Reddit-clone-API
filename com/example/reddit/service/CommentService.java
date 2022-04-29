package com.example.reddit.service;


import com.example.reddit.dto.CommentsDto;
import com.example.reddit.model.Comment;
import com.example.reddit.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;


    public Comment save(CommentsDto commentsDto){
        return commentRepository.save(mapToComment(commentsDto));
    }

    public Comment mapToComment(CommentsDto commentsDto){
        return Comment.builder().id(commentsDto.getId())
                .user(commentsDto.getUser())
                .text(commentsDto.getText())
                .build();
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

}
