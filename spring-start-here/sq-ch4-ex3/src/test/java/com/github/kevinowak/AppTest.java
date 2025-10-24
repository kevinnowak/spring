package com.github.kevinowak;

import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.proxy.CommentNotificationProxy;
import com.github.kevinnowak.repository.CommentRepository;
import com.github.kevinnowak.service.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AppTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentNotificationProxy commentNotificationProxy;

    @InjectMocks
    private CommentService commentService;

    @Test
    @DisplayName("""
            Verify that dependencies of the CommentService object are correctly called.
            """)
    public void testCommentService() {
        // Given
        var comment = new Comment("Kevin", "Lorem ipsum...");

        // When
        commentService.publishComment(comment);

        // Then
        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendComment(comment);
    }
}
