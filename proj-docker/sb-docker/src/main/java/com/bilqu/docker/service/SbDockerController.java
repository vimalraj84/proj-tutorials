package com.bilqu.docker.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SbDockerController {

    @GetMapping(path = "/sayHello/{name}")
    public void sayHello(@PathVariable(name = "name") String name){

        System.out.format("Hello %s", name);

    }
}
