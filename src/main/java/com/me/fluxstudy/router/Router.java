package com.me.fluxstudy.router;

import com.me.fluxstudy.handler.HelloWorldHandler;
import com.me.fluxstudy.handler.UserHandler;
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

    @Resource
    private UserHandler userHandler;

    @Bean
    public RouterFunction<?> routerFunction(){
        return RouterFunctions.route(RequestPredicates.GET("/hello"), helloWorldHandler::helloWorld)
                .andRoute(RequestPredicates.GET("/logger"), helloWorldHandler::testLogger)
                .andRoute(RequestPredicates.GET("/test"), helloWorldHandler::test)
                .andRoute(RequestPredicates.GET("/users"), userHandler::getUsers)
                .andRoute(RequestPredicates.GET("/user"), userHandler::getUserById)
                .andRoute(RequestPredicates.GET("/user"), userHandler::getUserById);
    }
}
