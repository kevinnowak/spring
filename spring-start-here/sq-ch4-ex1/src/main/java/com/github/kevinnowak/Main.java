package com.github.kevinnowak;

import com.github.kevinnowak.model.Comment;
import com.github.kevinnowak.proxy.EmailCommentNotificationProxy;
import com.github.kevinnowak.repository.DBCommentRepository;
import com.github.kevinnowak.service.CommentService;

public class Main {
    public static void main(String[] args) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        var comment = new Comment("Kevin", "Lorem ipsum...");

        commentService.publishComment(comment);
    }
}