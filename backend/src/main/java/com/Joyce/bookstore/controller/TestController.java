package com.Joyce.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String index() {
       return "forward:/index.html";
    }

}