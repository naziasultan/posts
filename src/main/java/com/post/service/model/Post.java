package com.post.service.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {

    private Long authorId;
    private String text;

}
