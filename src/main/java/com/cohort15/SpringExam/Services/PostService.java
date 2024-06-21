package com.cohort15.SpringExam.Services;

import com.cohort15.SpringExam.Models.Post;
import com.cohort15.SpringExam.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService
{
    @Autowired
    PostRepository postRepository;

    public Iterable<Post> getAllPosts()
    {
        return postRepository.findAll();
    }
    public Post getPostByID(Long postID)
    {
        Post dapost = postRepository.getReferenceById(postID);
        if (dapost==null)
            throw new PostNotFoundException("Post with ID "+postID+" not found!");
    }
}
