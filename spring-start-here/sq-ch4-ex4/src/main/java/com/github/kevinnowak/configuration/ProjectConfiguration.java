package com.github.kevinnowak.configuration;

import com.github.kevinnowak.proxy.CommentNotificationProxy;
import com.github.kevinnowak.proxy.EmailCommentNotificationProxy;
import com.github.kevinnowak.repository.CommentRepository;
import com.github.kevinnowak.repository.DBCommentRepository;
import com.github.kevinnowak.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    CommentNotificationProxy emailCommentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    CommentService commentService(CommentRepository commentRepository,
                                  CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(commentRepository, commentNotificationProxy);
    }
}
