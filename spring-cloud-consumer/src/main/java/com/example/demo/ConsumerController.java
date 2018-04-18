package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 18/4/2.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloRemote HelloRemote;

    @Autowired
    HiRemote hiRemote;

    @Autowired
    HelloRemote2 HelloRemote2;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name) + "###" + hiRemote.syaHiFromClientOne(name);
    }
    @RequestMapping("/hello2/{name}")
    public String index2(@PathVariable("name") String name) {
        return "hello2:" + HelloRemote2.hello(name);
    }

}
