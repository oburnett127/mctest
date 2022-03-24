package com.example.marketboard.factory;

import com.example.marketboard.model.Post;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public class PostFactory {

    public Post get(final String type){
        if ("Base".equals(type)){
            return Post.builder().build();
        }
        throw new InvalidParameterException("An invalid parameter exception has occurred.");
    }
}
//