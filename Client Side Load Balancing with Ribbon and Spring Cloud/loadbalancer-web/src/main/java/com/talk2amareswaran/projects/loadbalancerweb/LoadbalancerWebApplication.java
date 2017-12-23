package com.talk2amareswaran.projects.loadbalancerweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoadbalancerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalancerWebApplication.class, args);
	}
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value="/helloworld", method=RequestMethod.GET)
	public String helloworld() {
		return "Response from Hello World application and the server port is:"+port;
	}
	
	@RequestMapping(value="/")
	public String home() {
		return "Okay!";
	}
}
