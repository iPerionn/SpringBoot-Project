package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Activity;
import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConcreteCommentService implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveAvis(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByActivity(Activity activity) {
        return commentRepository.findByActivity(activity);
    }
    
    
}
