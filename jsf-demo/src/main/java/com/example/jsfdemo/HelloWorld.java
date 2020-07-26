package com.example.jsfdemo;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Component("helloBean")
@Scope("request")
public class HelloWorld {

    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public HelloWorld() {
        System.err.println("HelloWorld started!");
        greeting = "Hello There";
    }

    public String getMessage() {


        return greeting;
    }

}