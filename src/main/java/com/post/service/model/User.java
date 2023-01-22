package com.post.service.model;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private int amountOfPosts;
}
