package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jason on 18/3/19.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String syaHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry " + name + " from hystric";
    }
}
