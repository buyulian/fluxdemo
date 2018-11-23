package com.me.fluxstudy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.Random;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Service
public class HelloWorldHandler {

    Logger logger= LoggerFactory.getLogger(HelloWorldHandler.class);

    public Mono<ServerResponse> helloWorld(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromObject("hello world"));
    }

    public Mono<ServerResponse> testLogger(ServerRequest request){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromObject("logger"));
    }

    public Mono<ServerResponse> test(ServerRequest request){
        String id=request.queryParam("id").orElse("-1");
        logger.info(id+" start");
        final Mono<ServerResponse> serverResponseMono = Mono.fromCallable(() -> {
            logger.info(id + " before");
            Thread.sleep(1000 * 2);
            logger.info(id + " after");
            return "hello " + id;
        })
                .publishOn(Schedulers.elastic())
                .publishOn(Schedulers.single())
                .flatMap(s -> {
                    logger.info(id + " end");
                    return ServerResponse.ok()
                            .contentType(MediaType.TEXT_PLAIN)
                            .body(fromObject(s));
                });
        logger.info(id + "all end");
        return serverResponseMono;

    }
}
