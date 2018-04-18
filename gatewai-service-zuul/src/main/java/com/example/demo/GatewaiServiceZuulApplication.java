package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewaiServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaiServiceZuulApplication.class, args);
	}

	@Bean
	public TestFilter testFilter(){
		return new TestFilter();
	}
}
