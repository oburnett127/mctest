package com.example.marketboard.controller;

import com.example.marketboard.model.Comment;
import com.example.marketboard.model.CommentRequest;
import com.example.marketboard.model.CreateCommentRequest;
import com.example.marketboard.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@Slf4j
public class CommentController {

    private final CommentService service;

    public CommentController(final CommentService service){
        this.service = service;
    }

//    @GetMapping("/view")
//    public ResponseEntity<List<Comment>> view() {
//        final var result = service.listAll();
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/comment")
    public ResponseEntity<Comment> getComment(@Validated @RequestBody CommentRequest commentRequest) {
        final var comment = service.getComment(commentRequest.getId());
        return ResponseEntity.ok().body(comment);
    }


    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@Validated @RequestBody CreateCommentRequest createCommentRequest) throws IOException {
        final var comment = Comment.builder()
                .content(createCommentRequest.getContent())
                .stocks(createCommentRequest.getStocks())
                .account(createCommentRequest.getAccount())
                .build();
        service.createComment(comment);
        return ResponseEntity.ok(comment);
    }
}
////Hello world