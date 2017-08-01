package com.brico.compare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by edeltil on 22/03/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.brico.compare")
@PropertySource(value = { "classpath:application.yml" })
public class EtlConfiguration {
	private EtlConfiguration() {
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
