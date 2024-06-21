package com.cohort15.SpringExam.Controllers;

import com.cohort15.SpringExam.Models.Post;
import com.cohort15.SpringExam.Response.PostResponse;
import com.cohort15.SpringExam.Response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PostController
{
    @Autowired
    PostResponse postResponse;
    @PostMapping("/users/{userID}/posts")
    public ResponseEntity<?> createPost(@RequestBody Post post)
    {
        return new ResponseEntity<>(postResponse.createNewPost(userName), HttpStatus.CREATED);
    }
    @GetMapping("/users/{userID}/posts")
    public ResponseEntity<?> createPost()
    {
        return new ResponseEntity<>(postResponse.createNewPost(userName), HttpStatus.CREATED);
    }


    Endpoints needed for user are as follows:
    Create a post
    Get a post by id
    Get all posts
    Get a post by title
    Delete a post
    Update a post
    Get all posts by a user id
}
