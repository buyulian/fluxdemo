package com.example.fluxstudy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class HelloWorldHandler {

    Logger logger= LoggerFactory.getLogger(HelloWorldHandler.class);

    public Mono<ServerResponse> helloWorld(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello world"));
    }

    public Mono<ServerResponse> testLogger(ServerRequest request){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("logger"));
    }
}
