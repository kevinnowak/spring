package com.github.kevinnowak;

import com.github.kevinnowak.configuration.ProjectConfiguration;
import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment("Kevin", "Lorem ipsum...");
        var s = new String();

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
