package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 18/4/2.
 */
@RestController
public class HelloController {

    @Autowired
    HelloRemote HelloRemote;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
//        return "hello "+name+"，this is first messge";
        return HelloRemote.hello(name) ;
    }
}