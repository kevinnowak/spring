package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);
        Comment comment = new Comment("Demo comment", "Natasha");
        service.publishComment(comment);
    }
}
