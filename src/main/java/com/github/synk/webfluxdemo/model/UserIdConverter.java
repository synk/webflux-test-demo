package com.github.synk.webfluxdemo.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserIdConverter implements Converter<String, UserId> {
    @Nullable
    @Override
    public UserId convert(String source) {
        return new UserId(source);
    }
}
