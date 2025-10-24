package com.github.kevinnowak.service;

import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.proxy.CommentNotificationProxy;
import com.github.kevinnowak.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
