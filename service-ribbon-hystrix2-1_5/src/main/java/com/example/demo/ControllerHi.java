package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 18/3/19.
 */
@RestController
public class ControllerHi {

    @Autowired
    ServiceHi2 serviceHi;

    @RequestMapping(value = "hi")
    public String hi(@RequestParam String name){
        return serviceHi.hiService2(name);
//        return "hello hi";
    }
}
