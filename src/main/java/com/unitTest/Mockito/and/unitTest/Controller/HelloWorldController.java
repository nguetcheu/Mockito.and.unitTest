package com.unitTest.Mockito.and.unitTest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    private String helloWorld() {
        return "Hello World";
    }
}
