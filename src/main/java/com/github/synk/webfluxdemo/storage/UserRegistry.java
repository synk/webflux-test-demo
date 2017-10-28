package com.github.synk.webfluxdemo.storage;

import com.github.synk.webfluxdemo.model.User;
import com.github.synk.webfluxdemo.model.UserId;

import reactor.core.publisher.Mono;

public interface UserRegistry {
    Mono<User> getUser(UserId id);
}
