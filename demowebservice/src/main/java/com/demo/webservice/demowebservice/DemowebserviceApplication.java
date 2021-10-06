package com.demo.webservice.demowebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class DemowebserviceApplication extends SpringBootServletInitializer {
	
	@RequestMapping("/")
	String home() {
		return "  home demo web service ";
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(DemowebserviceApplication.class);
	  }
   
	public static void main(String[] args) {
		SpringApplication.run(DemowebserviceApplication.class, args);
		
		
	}

}
