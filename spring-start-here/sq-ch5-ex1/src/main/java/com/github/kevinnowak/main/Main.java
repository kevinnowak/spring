package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var bean1 = context.getBean("commentService", CommentService.class);
        var bean2 = context.getBean("commentService", CommentService.class);
        System.out.println(bean1.equals(bean2));
    }
}