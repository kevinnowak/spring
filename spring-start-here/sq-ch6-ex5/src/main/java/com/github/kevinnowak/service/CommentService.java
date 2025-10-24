package com.github.kevinnowak.service;

import com.github.kevinnowak.aspect.ToLog;
import com.github.kevinnowak.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.text());

        return "SUCCESS";
    }

    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.text());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.text());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
