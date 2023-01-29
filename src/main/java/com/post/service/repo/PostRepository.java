package com.post.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
        Optional<Post> findById(Long id);
        @Transactional
        Post save(Post post);
}
