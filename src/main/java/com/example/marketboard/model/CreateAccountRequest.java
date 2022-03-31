package com.example.marketboard.model;

import lombok.Data;

import java.util.List;

@Data
public class CreateAccountRequest {
    private String email;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private List<Comment> comments;
}
////Hello world