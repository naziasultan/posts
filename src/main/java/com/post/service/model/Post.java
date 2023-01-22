package com.post.service.model;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class Post {
    private Long id;
    private Long authorId;
    private String text;
    private String postedAt;
}
