package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService1 = context.getBean("commentService", CommentService.class);
        var commentService2 = context.getBean("commentService", CommentService.class);

        System.out.println(commentService1 == commentService2);
    }
}