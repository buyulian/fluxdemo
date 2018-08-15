package com.example.fluxstudy.controller;

import com.example.fluxstudy.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {

    @GetMapping("person")
    public Person helloWorld(){
        Person person=new Person();
        person.setId(1);
        person.setName("nj");
        return person;
    }
}
