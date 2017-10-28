package com.github.synk.webfluxdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.synk.webfluxdemo.config.DemoProperties;
import com.github.synk.webfluxdemo.model.User;
import com.github.synk.webfluxdemo.model.UserId;
import com.github.synk.webfluxdemo.storage.UserRegistry;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class DemoController {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final DemoProperties properties;

    private final UserRegistry userRegistry;

    @GetMapping("/user/{id}")
    public Mono<User> user(@PathVariable("id") UserId id) throws Exception {
        return userRegistry.getUser(id);
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> create(@RequestBody User user) throws Exception {
        return Mono.just(new User(user.getId(), properties.getPrefix() + user.getName()));
    }

    @GetMapping("/exceptions")
    public Mono<String> exceptions() {
        return Mono.error(new IllegalArgumentException("hoge"));
    }
}
