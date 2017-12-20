package com.talk2amareswaran.projects.timezoneapp;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TimezoneappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimezoneappApplication.class, args);
	}
	
	@RequestMapping(value="/timezone", method=RequestMethod.GET)
	public String getTimezone() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeZone().getID();
	}
}