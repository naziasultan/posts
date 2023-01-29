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

import java.util.Optional;

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
    public com.post.service.repo.Post getPost(@PathVariable("id") Long id) {
        Optional<com.post.service.repo.Post> response =  postService.getPost(id);

            return response.orElseThrow();

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<
            com.post.service.repo.Post> createPost(@RequestBody Post post) {
        com.post.service.repo.Post response = postService.createPost(post);
        if(response != null)
            return ResponseEntity.ok(response);
         else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);

    }

    @PutMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<com.post.service.repo.Post> updatePost(@PathVariable("id") Long id) {

        return postService.updatePost(id);

    }
}
