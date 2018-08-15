package com.example.fluxstudy.router;

import com.example.fluxstudy.handler.HelloWorldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import javax.annotation.Resource;

@Configuration
public class Router {
    @Resource
    private HelloWorldHandler helloWorldHandler;

    @Bean
    public RouterFunction<?> routerFunction(){
        return RouterFunctions.route(RequestPredicates.GET("/hello"), helloWorldHandler::helloWorld);
    }
}
