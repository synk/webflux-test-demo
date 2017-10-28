package com.github.synk.webfluxdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.synk.webfluxdemo.storage.UserRegistry;

@Configuration
public class UserRegistryConfig {

    @Bean
    public UserRegistry userRegistry() {
        throw new IllegalStateException("this must not be loadedby @WebFluxTest");
    }
}
