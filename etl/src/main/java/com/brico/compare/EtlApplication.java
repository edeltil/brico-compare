package com.brico.compare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EtlApplication {
	private EtlApplication() {
	}

	@SuppressWarnings("squid:S2095")
	public static void main(String[] args) {
		SpringApplication.run(EtlApplication.class);
	}
}
