package com.post.service.repo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity(name = "user")
@Data
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private Long authorId;
        private String text;
        @Column(name = "postedat")
        private LocalDate postedAt = LocalDate.now();

        public Post(Long authorId, String text) {

                this.authorId=authorId;
                this.text=text;
        }

}
