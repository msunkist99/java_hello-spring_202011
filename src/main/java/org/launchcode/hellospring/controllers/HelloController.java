package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //tells SpringBoot that this is a Controller class
@ResponseBody   //tells SpringBoot that all methods in this class return a plain text html response
@RequestMapping("hello")    //all requests to methods in this controller start with /hello
public class HelloController {

    // Handles request at path /hello
    @GetMapping("")
    public String hello(){
        return "Hello, Spring!";
    }

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")  //tells SpringBoot that this method should handle only GET requests
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello/hello?name=LaunchCode -- query string
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryString(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles request of the form hello//hello/LaunchCode -- path parameter
    @GetMapping("hello/{name}")

    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // handles request of form /hello/form
    @GetMapping("form") //accepts GET requests
    public String helloForm(){
        String html =
                "<html>" +
                        "<body>" +
                            "<form method='post' action='/hello/hello'>" +
                                "<input type='text' name='name'>" +
                                "<input type='submit' value='Greet me!'>" +
                            "</form>" +
                        "</body>" +
                "</html>";

        return html;
    }

    // handles request of form /hello/formlanguage
    @GetMapping("formlanguage") //accepts GET requests
    public String helloFormLanguage(){
        String html =
                "<html>" +
                        "<body>" +
                        "<form method='post' action='/hello/helloLanguage'>" +
                        "<input type='text' name='name'>" +
                        "<select name='language' id='language-select'>" +
                            "<option value=''>--Please select a language--</option>" +
                            "<option value='french'>French</option>" +
                            "<option value='spanish'>Spanish</option>" +
                            "<option value='german'>German</option>" +
                            "<option value='latin'>Latin</option>" +
                            "<option value='russian'>Russian</option>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</select>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    // Handles request of the form /hello/helloLanguage?name=LaunchCode -- query string
    @RequestMapping(value="helloLanguage", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloLanguage(@RequestParam String name, String language){
        //return createMessage(name, language);

        return "<h1 style='font-family:verdana; text-align:center; color:green'>" + createMessage(name,language) + "</h1>";
    }

    public static String createMessage(String name, String language) {
        if (language.equals("french")){
            return "Bonjour, " + name + "!";
        }

        if (language.equals("spanish")){
            return "Hola, " + name + "!";
        }

        if (language.equals("german")){
            return "Guten tag, " + name + "!";
        }

        if (language.equals("latin")){
            return "Salve, " + name + "!";
        }

        if (language.equals("russian")){
            return "Zdras-tvuy-te, " + name + "!";
        }

        return "Hello, " + name + "!";
    }
}
