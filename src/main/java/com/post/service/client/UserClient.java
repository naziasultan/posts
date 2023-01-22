package com.post.service.client;

import com.post.service.model.User;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserClient {
    @RequestLine("PUT /{id}")
    @Headers("Content-Type: application/json")
    User updateUser(@Param("id") Long id);
}