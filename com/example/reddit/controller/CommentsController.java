package com.example.reddit.controller;

import com.example.reddit.dto.CommentsDto;
import com.example.reddit.model.Comment;
import com.example.reddit.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentsController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentsDto commentsDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.save(commentsDto));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(){
       return ResponseEntity.status(HttpStatus.OK)
               .body(commentService.getAllComments());
    }

}
