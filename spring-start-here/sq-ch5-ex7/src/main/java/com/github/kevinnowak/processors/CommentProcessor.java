package com.github.kevinnowak.processors;

import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.repositories.CommentRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

    private final CommentRepository commentRepository;

    public CommentProcessor(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void processComment(Comment comment) {
        System.out.println("Processing comment " + comment);
    }

    public void validateComment(Comment comment) {
        System.out.println("Validating comment " + comment);
    }
}
