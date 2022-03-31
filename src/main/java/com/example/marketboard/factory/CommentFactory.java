package com.example.marketboard.factory;

import com.example.marketboard.model.Comment;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public class CommentFactory {

    public Comment get(final String type){
        if ("Base".equals(type)){
            return Comment.builder().build();
        }
        throw new InvalidParameterException("An invalid parameter exception has occurred.");
    }
}
////Hello world