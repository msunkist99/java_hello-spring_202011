package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller                 //tells SpringBoot that this is a Controller class
@RequestMapping("hello")    //all requests to methods in this controller start with /hello
public class HelloController {

    // Handles request for /hello?name=LaunchCode -- query string
    @RequestMapping(value="", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryString(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // handles request of form /hello/form
    @GetMapping("form") //accepts GET requests
    public String helloForm(){
        return "helloForm";
    }
}
