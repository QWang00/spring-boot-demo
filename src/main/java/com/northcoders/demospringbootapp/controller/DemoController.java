package com.northcoders.demospringbootapp.controller;


import com.northcoders.demospringbootapp.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class DemoController {
    @GetMapping("/hello")
    public String getGreetings(){
        return "Hello there!";
    }


    Person person = new Person("Emma", 18, "emma18@gmail.com", "England", "Roast dinner");

    @GetMapping("/helloEmma")
    public Person greeterEmma (){
        return person;
    }


}


