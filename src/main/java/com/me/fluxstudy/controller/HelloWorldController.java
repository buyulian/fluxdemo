package com.me.fluxstudy.controller;

import com.me.fluxstudy.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
