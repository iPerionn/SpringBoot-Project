package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Activity;
import com.example.demo.model.Comment;

public interface CommentService {
    Comment saveComment(Comment avis);
    List<Comment> findByActivity(Activity activity);
}
