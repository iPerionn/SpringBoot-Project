package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Activity;
import com.example.demo.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    ArrayList<Comment> findByActivity(Activity activity);
}
