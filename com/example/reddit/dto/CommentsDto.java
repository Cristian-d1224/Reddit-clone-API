package com.example.reddit.dto;


import com.example.reddit.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {

    private Long id;

    private User user;

    private Long postId;

    private Instant createdDate;

    private String text;

    private String userName;

}
