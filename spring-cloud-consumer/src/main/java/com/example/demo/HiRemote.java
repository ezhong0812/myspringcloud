package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jason on 18/4/2.
 */

@FeignClient(value = "service-hi")
public interface HiRemote {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String syaHiFromClientOne(@RequestParam(value = "name") String name);
}
