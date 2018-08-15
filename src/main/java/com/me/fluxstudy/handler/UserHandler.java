package com.me.fluxstudy.handler;

import com.me.fluxstudy.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service
public class UserHandler {

    @Resource
    private UserService userService;

    public Mono<ServerResponse> getUsers(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject(userService.getUsers()));
    }
}
