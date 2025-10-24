package com.github.kevinnowak.repository;

import com.github.kevinnowak.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);
}
