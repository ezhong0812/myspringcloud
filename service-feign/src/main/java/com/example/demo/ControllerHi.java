package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 18/3/19.
 */
@RestController
public class ControllerHi {
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "hi2", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.syaHiFromClientOne(name);
    }
}
