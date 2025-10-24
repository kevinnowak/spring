package com.github.kevinnowak;

import com.github.kevinnowak.aspect.LoggingAspect;
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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

    private Logger serviceLogger;
    private Logger aspectLogger;

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    public void before() {
        this.aspectLogger = mock(Logger.class);
        loggingAspect.setLogger(aspectLogger);

        this.serviceLogger = mock(Logger.class);
        commentService.setLogger(serviceLogger);
    }

    @Test
    @DisplayName("Test that the aspect intercepts and alters the execution of the deleteComment() method.")
    public void testAspectInterceptsDeleteCommentMethod() {
        Comment comment = new Comment("Test comment text", "Test comment author");
        commentService.deleteComment(comment);
        verify(serviceLogger).info("Deleting comment: " + comment.text());
        verify(aspectLogger).info("Method deleteComment with parameters [Comment[text=Test comment text, author=Test comment author]] will execute");
        verify(aspectLogger).info("Method executed and returned null");
    }

    @Test
    @DisplayName("Test that the aspect doesn't intercept the execution of the publishComment() method.")
    public void testAspectDoesntInterceptPublishCommentMethod() {
        Comment comment = new Comment("Test comment text", "Test comment author");
        commentService.publishComment(comment);
        verify(serviceLogger).info("Publishing comment: " + comment.text());
        verify(aspectLogger, never()).info(anyString());
        verify(aspectLogger, never()).info(anyString());
    }

    @Test
    @DisplayName("Test that the aspect doesn't intercept the execution of the editComment method.")
    public void testAspectDoesntInterceptEditCommentMethod() {
        Comment comment = new Comment("Test comment text", "Test comment author");
        commentService.editComment(comment);
        verify(serviceLogger).info("Editing comment: " + comment.text());
        verify(aspectLogger, never()).info(anyString());
        verify(aspectLogger, never()).info(anyString());
    }
}
