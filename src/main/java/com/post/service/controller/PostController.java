package com.post.service.controller;

import com.post.service.model.Post;
import com.post.service.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable("id") Long id) {
        Post response =  postService.getPost(id);
        if(response != null)
            return ResponseEntity.ok(response);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post response = postService.createPost(post);
        if(response != null)
            return ResponseEntity.ok(response);
         else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> deletePost(@PathVariable("id") Long id) {
        Post response = postService.deletePost(id);
        if(response != null)
            return ResponseEntity.ok(response);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id) {
        if(id==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Post response = postService.updatePost(id);
        if (response != null)
            return ResponseEntity.ok(response);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
