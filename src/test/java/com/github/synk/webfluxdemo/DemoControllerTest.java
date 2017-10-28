package com.github.synk.webfluxdemo;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.github.synk.webfluxdemo.model.User;
import com.github.synk.webfluxdemo.model.UserId;
import com.github.synk.webfluxdemo.storage.UserRegistry;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest
public class DemoControllerTest {

    @MockBean
    private UserRegistry userRegistry;

    @Autowired
    private WebTestClient client;

    @Test
    public void get() {
        final UserId id = new UserId("my-id");
        when(userRegistry.getUser(id)).thenReturn(Mono.just(new User(id.getId(), "my-name")));
        client.get()
              .uri("/user/{id}", "my-id")
              .exchange()
              .expectBody().json("{\"id\":\"my-id\",\"name\":\"my-name\"}");
    }

    @Test
    public void create() {
        client.post()
              .uri("/user")
              .body(Mono.just(new User("my-id", "my-name")), User.class)
              .exchange()
              .expectBody().json("{\"id\":\"my-id\",\"name\":\"test-my-name\"}");
    }

    @Test
    public void exceptions() {
        client.get()
              .uri("/exceptions")
              .exchange()
              .expectBody().json("{\"message\":\"hoge\"}");
    }

}
