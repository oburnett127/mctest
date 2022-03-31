package com.example.marketboard.service;

import com.example.marketboard.model.Comment;
import com.example.marketboard.model.Comment;

import java.math.BigDecimal;
import java.util.List;

public interface CommentOperations {
    List<Comment> listAll(int postid);
    void createComment(Comment account);
    Comment getComment(int id);
    Comment updateComment(int id);
    Comment deleteComment(int id);
}
////Hello world