package com.post.service.service;

import com.post.service.client.UserClient;
import com.post.service.repo.Post;
import com.post.service.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostService {

   // Map<Long, Post> postMap = new HashMap<>();
    @Autowired
    PostRepository repository;
    @Autowired
    private UserClient client;

    public Optional<com.post.service.repo.Post> getPost(Long id){
       return repository.findById(id);
    }
    @Transactional
    public Post createPost(com.post.service.model.Post post){
        Long authorId = post.getAuthorId();
       Post newPost = new Post(post.getAuthorId(), post.getText());
        repository.save(newPost);

       client.updateUser(authorId);
        return newPost;
    }
    public void deletePost(Long id){
      repository.deleteById(id);
    }

    public Optional<Post> updatePost(Long id){
        Optional<Post> post = repository.findById(id);

        return post;
    }
}
