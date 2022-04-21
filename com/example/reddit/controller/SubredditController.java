package com.example.reddit.controller;

import com.example.reddit.dto.SubredditDto;
import com.example.reddit.model.Subreddit;
import com.example.reddit.service.SubredditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
public class SubredditController {

    private final SubredditService subredditService;

    @PostMapping
    public ResponseEntity<SubredditDto> createSubreddit(@RequestBody SubredditDto subredditDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subredditService.save(subredditDto));
    }

    @GetMapping
    public ResponseEntity<List<Subreddit>> getAllSubreddits(){
        return ResponseEntity.status(HttpStatus.OK).body(subredditService.getAll());
    }

}
