package com.github.kevinnowak;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Check if the bean is a singleton")
    public void testCommentServiceIsSingleton() {
        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        assertEquals(cs1, cs2);
    }
}
