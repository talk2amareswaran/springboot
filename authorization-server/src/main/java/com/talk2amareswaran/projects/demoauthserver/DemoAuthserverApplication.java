package com.talk2amareswaran.projects.demoauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class DemoAuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuthserverApplication.class, args);
	}
}
