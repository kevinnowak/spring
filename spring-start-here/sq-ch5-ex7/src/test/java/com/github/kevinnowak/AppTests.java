package com.github.kevinnowak;

import com.github.kevinnowak.config.ProjectConfig;
import com.github.kevinnowak.repositories.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testCommentRepositoryIsPrototype() {
        var cr1 = context.getBean("commentRepository", CommentRepository.class);
        var cr2 = context.getBean("commentRepository", CommentRepository.class);

        assertNotEquals(cr1, cr2);
    }
}
