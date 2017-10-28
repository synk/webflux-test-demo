package com.github.synk.webfluxdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("demo")
public class DemoProperties {

    private String prefix;
}
