package com.github.kevinnowak.services;

import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.processors.CommentProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final ApplicationContext context;

    public CommentService(ApplicationContext context) {
        this.context = context;
    }

    public void sendComment(Comment c) {
        CommentProcessor p = context.getBean(CommentProcessor.class);
        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
        c = p.getComment();
    }
}
