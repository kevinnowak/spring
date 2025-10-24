package com.github.kevinnowak.proxy;

import com.github.kevinnowak.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
