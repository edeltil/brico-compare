package com.brico.compare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
public class PortailApplication {

	private PortailApplication() {
	}

	@SuppressWarnings("squid:S2095")
	public static void main(String[] args) {
		System.setProperty("spring.profiles.default", System.getProperty("spring.profiles.default", "dev"));
		SpringApplication.run(PortailApplication.class,args);
	}
}
