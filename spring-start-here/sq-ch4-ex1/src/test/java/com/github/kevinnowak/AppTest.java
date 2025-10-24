package com.github.kevinnowak;

import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.proxy.CommentNotificationProxy;
import com.github.kevinnowak.repository.CommentRepository;
import com.github.kevinnowak.service.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppTest {

    @Test
    @DisplayName("""
            Verify that CommentService correctly delegates the responsibilities to the repository and proxy objects
            """)
    public void testCommentService() {
        // Given
        var comment = mock(Comment.class);
        var commentRepository = mock(CommentRepository.class);
        var commentNotificationProxy = mock(CommentNotificationProxy.class);
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        // When
        commentService.publishComment(comment);

        // Then
        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendComment(comment);
    }
}
