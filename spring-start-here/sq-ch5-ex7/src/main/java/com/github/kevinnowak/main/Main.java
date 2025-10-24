package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService = c.getBean(CommentService.class);
        commentService.sendComment(new Comment());
        commentService.sendComment(new Comment());
    }
}