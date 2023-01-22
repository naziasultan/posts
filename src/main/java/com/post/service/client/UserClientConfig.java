package com.post.service.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.post.service.exception.CustomErrorDecoder;
import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class UserClientConfig {
        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        public UserClientConfig(ObjectMapper objectMapper){
            this.objectMapper= objectMapper;
        }

        @Bean
        public UserClient userServiceClient(@Value("http://localhost:8080/users") final String endpoint) {
            return Feign.builder()
                    .encoder(new FormEncoder(new JacksonEncoder(objectMapper)))
                    .decoder(new JacksonDecoder(objectMapper))
                    .decode404()
                    .errorDecoder(new CustomErrorDecoder())
                    .target(UserClient.class, endpoint);
        }

}
