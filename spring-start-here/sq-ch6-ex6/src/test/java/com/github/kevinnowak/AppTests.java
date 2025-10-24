package com.github.kevinnowak;

import com.github.kevinnowak.aspect.LoggingAspect;
import com.github.kevinnowak.aspect.SecurityAspect;
import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    private Logger serviceLogger;
    private Logger loggingAspectLogger;
    private Logger securityAspectLogger;

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private SecurityAspect securityAspect;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    public void before() {
        this.loggingAspectLogger = mock(Logger.class);
        loggingAspect.setLogger(loggingAspectLogger);
        this.securityAspectLogger = mock(Logger.class);
        securityAspect.setLogger(securityAspectLogger);
        this.serviceLogger = mock(Logger.class);
        commentService.setLogger(serviceLogger);
    }

    @Test
    @DisplayName("Test that both aspects intercept the execution" +
        " of the publishComment() method.")
    public void testAspectInterceptsPublishCommentMethod() {
        Comment comment = new Comment("Test comment text", "Test comment author");
        commentService.publishComment(comment);
        verify(serviceLogger).info("Publishing comment: " + comment.text());
        verify(securityAspectLogger).info("Security Aspect: Calling the intercepted method");
        verify(loggingAspectLogger).info("Logging Aspect: Calling the intercepted method");
    }

}
