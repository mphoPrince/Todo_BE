package com.example.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//controller (handles http request)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController  {

    //method to return "Hello world"
    //get method
    //uri -/helloworld
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
//    @GetMapping(path = "/hello-world") this is the shorter method of request mapping
    public String helloWorld() {
        return "hello World";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-bean")
//    @GetMapping(path = "/hello-world") this is the shorter method of request mapping
    public HelloWorldBean helloWorldBean(){
        throw new RuntimeException("some Error has occured! contact support at 061 772 8938");
//        return new HelloWorldBean("hello World changed");
    }

//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-variable/{name}")
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("hello World,%s",name));
    }

}
