package com.github.synk.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.github.synk.webfluxdemo.config.DemoProperties;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
public class WebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxDemoApplication.class, args);
    }
}
