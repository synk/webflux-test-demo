package com.github.synk.webfluxdemo.storage;

import org.springframework.stereotype.Component;

import com.github.synk.webfluxdemo.model.User;
import com.github.synk.webfluxdemo.model.UserId;

import reactor.core.publisher.Mono;

@Component
public class RealUserRegistry implements UserRegistry {
    @Override
    public Mono<User> getUser(UserId id) {
        return Mono.error(new UnsupportedOperationException());
    }
}
