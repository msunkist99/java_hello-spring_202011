package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller                 //tells SpringBoot that this is a Controller class
public class HelloController {
    //Responds to /hello?name=LaunchCode
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloQueryString(@RequestParam String name, Model model) {
        model.addAttribute("greeting", "Hello query string, " + name + "!");
        return "hello";
    }

    //Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloPathVariable(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello path variable, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "helloForm";
    }

    //Responds to /hello-names
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");

        model.addAttribute("names", names);

        return "helloList";
    }
}
