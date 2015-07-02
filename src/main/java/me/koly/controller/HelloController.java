package me.koly.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
