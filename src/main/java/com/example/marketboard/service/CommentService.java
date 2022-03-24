package com.example.marketboard.service;

import com.example.marketboard.dao.CommentDao;
import com.example.marketboard.model.Comment;
import com.example.marketboard.util.CommentValidator;
import com.example.marketboard.dao.CommentDao;
import com.example.marketboard.model.Comment;
import com.example.marketboard.util.CommentValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class CommentService implements CommentOperations {

    private final CommentDao commentDao;
    private final CommentValidator commentValidator;

    public CommentService(final CommentDao commentDao, final CommentValidator commentValidator) {
        this.commentDao = commentDao;
        this.commentValidator = commentValidator;
    }

    @Override
    public List<Comment> listAll(int postid) {
        return this.commentDao.getAll();
    }

    @Override
    public void createComment(Comment comment) {
        this.commentDao.create(comment);
    }

    @SneakyThrows
    public Comment getComment(final int id) {
        final var comment = commentDao.getComment(id);
        return comment;
    }
    
    @SneakyThrows
    public Comment updateComment(int id, BigDecimal amount) {
        final var comment = commentDao.getComment(id);
        commentValidator.withdraw(comment, amount);
        comment.setBalance(comment.getBalance().subtract(amount));
        commentDao.save(comment);
        return comment;
    }

    
}
//