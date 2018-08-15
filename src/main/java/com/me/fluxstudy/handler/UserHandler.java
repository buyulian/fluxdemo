package com.me.fluxstudy.handler;

import com.me.fluxstudy.model.User;
import com.me.fluxstudy.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserHandler {

    @Resource
    private UserService userService;

    public Mono<ServerResponse> getUsers(ServerRequest request){
        List<User> userList=userService.getUsers();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(userList));
    }
}
