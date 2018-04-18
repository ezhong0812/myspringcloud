package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        System.out.println(a.getClass());
        List list = Arrays.asList(a);
        System.out.println(list);
        list.forEach(i -> System.out.println(i));
        System.out.println("-----------------");
        Integer[] aa = {1, 2, 3, 4};
        System.out.println(aa.getClass());
        list = Arrays.asList(aa);
        list.set(1, 8);
        System.out.println(list);
        list.forEach(i -> System.out.println(i));
        System.out.println("######################################");

        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ", i am from port: " + port;
    }

}
