package com.example.marketboard.service;

import com.example.marketboard.dao.PostDao;
import com.example.marketboard.model.Post;
import com.example.marketboard.util.PostValidator;
import com.example.marketboard.dao.PostDao;
import com.example.marketboard.model.Post;
import com.example.marketboard.util.PostValidator;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PostService implements PostOperations {

    private final PostDao postDao;
    private final PostValidator postValidator;

    public PostService(final PostDao postDao, final PostValidator postValidator) {
        this.postDao = postDao;
        this.postValidator = postValidator;
    }

    @Override
    public List<Post> listAll(int postid) {
        return this.postDao.getAll();
    }

    @Override
    public void createPost(Post post) {
        this.postDao.create(post);
    }

    @SneakyThrows
    public Post getPost(final int id) {
        final var post = postDao.getPost(id);
        return post;
    }

    @SneakyThrows
    public Post updatePost(int id, BigDecimal amount) {
        final var post = postDao.getPost(id);
        postValidator.withdraw(post, amount);
        post.setBalance(post.getBalance().subtract(amount));
        postDao.save(post);
        return post;
    }

    @SneakyThrows
    public Post updatePost(int id, BigDecimal amount) {
        final var post = postDao.getPost(id);
        postValidator.withdraw(post, amount);
        post.setBalance(post.getBalance().subtract(amount));
        postDao.save(post);
        return post;
    }
}