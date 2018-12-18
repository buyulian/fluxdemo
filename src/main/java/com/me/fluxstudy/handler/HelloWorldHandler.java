package com.me.fluxstudy.handler;


import com.me.fluxstudy.model.Website;
import com.me.fluxstudy.service.WebsiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Service
public class HelloWorldHandler {

    Logger logger= LoggerFactory.getLogger(HelloWorldHandler.class);

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private WebsiteService websiteService;

    public Mono<ServerResponse> helloWorld(ServerRequest request){

        Website website=new Website();
        List<String> nameList=new LinkedList<>();
        nameList.add("Google");
        nameList.add("淘宝");
        website.setNameList(nameList);
        List<Website> websites = websiteService.listByCondition(website);

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
