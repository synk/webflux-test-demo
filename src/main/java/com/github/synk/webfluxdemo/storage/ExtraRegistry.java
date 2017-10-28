package com.github.synk.webfluxdemo.storage;

import org.springframework.stereotype.Component;

@Component
public class ExtraRegistry {

    public ExtraRegistry() {
        throw new IllegalStateException("this must not be loadedby @WebFluxTest");
    }
}
