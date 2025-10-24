package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.services.CommentService;
import com.github.kevinnowak.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        System.out.println(s1.getCommentRepository() == s2.getCommentRepository());
    }
}