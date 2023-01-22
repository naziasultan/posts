package com.post.service.service;

import com.post.service.client.UserClient;
import com.post.service.model.Post;
import com.post.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {

    Map<Long, Post> postMap = new HashMap<>();
    @Autowired
    private UserClient client;

    public Post getPost(Long id){
       return postMap.get(id);
    }
    public Post createPost(Post post){
        Long authorId = post.getAuthorId();
        Post newPost = Post.builder()
                .id(post.getId())
                .authorId(post.getAuthorId())
                .text(post.getText())
                .postedAt(post.getPostedAt())
                .build();
        postMap.put(post.getId(), newPost);
       client.updateUser(authorId);
        return newPost;
    }
    public Post deletePost(Long id){
      Post post =  postMap.get(id);
      if(post!=null)
        postMap.remove(id);
      return post;
    }

    public Post updatePost(Long id){
        Post post = postMap.get(id);
        post.setId(id);
        postMap.put(id, post);
        return post;
    }
}
