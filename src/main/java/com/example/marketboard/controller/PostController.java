package com.example.marketboard.controller;

import com.example.marketboard.model.Post;
import com.example.marketboard.constant.DebugMessage;
import com.example.marketboard.model.PostRequest;
import com.example.marketboard.model.CreatePostRequest;
import com.example.marketboard.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class PostController {

    private final PostService service;

    public PostController(final PostService service){
        this.service = service;
    }

//    @GetMapping("/view")
//    public ResponseEntity<List<Post>> view() {
//        final var result = service.listAll();
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/post")
    public ResponseEntity<Post> getPost(@Validated @RequestBody PostRequest postRequest) {
        final var post = service.getPost(postRequest.getId());
        return ResponseEntity.ok().body(post);
    }


    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@Validated @RequestBody CreatePostRequest createPostRequest) throws IOException {
        final var post = Post.builder()
                .postid(createPostRequest.getPostId())
                .accountId(createPostRequest.getAccountId)
                .title(createPostRequest.getTitle())
                .body(createPostRequest.getBody())
                .listOfStocks(createPostRequest.getListOfStocks())
                .build();
        service.createPost(post);
        log.debug(DebugMessage.MSG5,post.getFirstName(),post.getLastName(),post.getId());
        return ResponseEntity.ok(post);
    }

    @PostMapping("/update")
    public ResponseEntity<Post> updatePost(@Validated @RequestBody PostUpdateRequest postUpdateRequest) throws IOException {
        final var id = postUpdateRequest.getId();
        final var result = service.updatePost();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<Post> updatePost(@Validated @RequestBody PostDeleteRequest postDeleteRequest) throws IOException {
        final var id = postDeleteRequest.getId();
        final var result = service.deletePost();
        return ResponseEntity.ok().body(result);
    }
}
//Hello world