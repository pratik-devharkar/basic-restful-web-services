package com.pdev.rest.webservices.restfulwebservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*@RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWorld(){
        return "Hello World";
    }*/
    @GetMapping(path = "/hello")
    public HelloWorld helloWorld(){
        return new HelloWorld("Hello World I");
    }

    @GetMapping(path = "/hello/path-variable/{name}")
    public HelloWorld helloWorldPath(@PathVariable String name){
        return new HelloWorld("Hello World,"+ name);
    }
}
